var course = {
    java: ['Java100', 'Java200', "Java300"],
    frontend: ['HTML5', 'CSS3',  'JQuery'],
    mysql: ['Mysql100', 'Mysql200', 'Mysql300']

}


const course_id = {
    'Java100': ["Basic", "Looping and Functions"],
    'Java200': ["OOP", "Collections", "Lambda Functions"],
    'Java300': ["Data Structures", "Threading"],
    'HTML5': ["Html tags", "Forms"],
    'CSS3': ["Inline Css", "External Css"],
    'JQuery': ["Basic Jquery", "Advanced Jquery"],
    'Mysql100': ["Create database", "Adding tables"],
    'Mysql200': ["Add values", "Update values"],
    'Mysql300': ["Join tables", "Table Relationship"]
}



// getting the main and sub menus


var main = document.getElementById('main_menu');
var sub4 = document.getElementById('sub_menu');
var sub2 = document.getElementById('sub_menu2');
var sub3 = document.getElementById('sub_menu3');




// Trigger the Event when main menu change occurs

main.addEventListener('change', function () {
    selectOptionDynamic(this, 'sub_menu', course)
});


sub4.addEventListener('change', function () {
    selectOptionDynamic(this, 'sub_menu2', course_id)
});


sub2.addEventListener('change', function () {
    selectOptionDynamic(this, 'sub_menu3', course_title)
});

function selectOptionDynamic(selectedoption, submenu, submenuValueObject) {

    var sub = document.getElementById(submenu);
    // getting a selected option

    var selected_option = submenuValueObject[selectedoption.value];


    // removing the sub menu options using while loop



    while (sub.options.length > 0) {

        sub.options.remove(0);

    }


    //conver the selected object into array and create a options for each array elements 
    //using Option constructor  it will create html element with the given value and innerText



    Array.from(selected_option).forEach(function (el) {

        let option = new Option(el, el);

        //append the child option in sub menu

        sub.appendChild(option);

    });
}