const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener('click', () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener('click', () => {
    container.classList.remove("sign-up-mode");
});


function showPassword(){
    var x = document.getElementById("myInput");
    var hide1 = document.getElementById("hide1");
    var hide2 = document.getElementById("hide2");
    var w = document.getElementById("myInput2");

    if(x.type === 'password' || w.type ==='password'){
        x.type = "text";
        w.type = "text";
        hide1.style.display = "block";
        hide2.style.display = "none";
    }
    else{
        x.type = "password";
        w.type = "password";
        hide1.style.display = "none";
        hide2.style.display = "block";
    }


}





   
