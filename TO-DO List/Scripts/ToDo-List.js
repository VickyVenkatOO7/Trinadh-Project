/* const todoList = []; */

let todoList = JSON.parse(localStorage.getItem('todoList')) || [];

renderTodoList();

function renderTodoList() {

    let todoListHtml = '';

    todoList.forEach((todoObject, index) => {
        const { name, date } = todoObject;
        const html = `
            <div>${name}</div>
            <div>${date}</div>
            <button class="delete-todo-button js-delete-todo-button">
                Delete
            </button>
        `;
        todoListHtml += html;  
    });

    document.querySelector('.js-todo-list').innerHTML = todoListHtml;

    document.querySelectorAll('.js-delete-todo-button')
        .forEach((deleteButton, index) => {
            deleteButton.addEventListener('click', () => {
                todoList.splice(index, 1);
                localStorage.setItem('todoList', JSON.stringify(todoList));
                renderTodoList();
            });
        });
}

document.querySelector('.js-add-todo-button')
    .addEventListener('click', () => {
        addTodo();
    });

function addTodo() {
    const inputElement = document.querySelector('.js-name-input');
    const name = inputElement.value;

    const dateInputElement = document.querySelector('.js-date-input');
    const date = dateInputElement.value;

    todoList.push({
        name,
        date
    });

    localStorage.setItem('todoList', JSON.stringify(todoList));

    inputElement.value = '';
    dateInputElement.value='';

    renderTodoList();
}