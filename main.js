const hamburger = document.querySelector(".hamburger");
const navlink = document.querySelector(".nav-link");
const links = document.querySelectorAll(".nav-link li");

hamburger.addEventListener('click',() =>{
    navlink.classList.toggle("open");
})


var input = document.querySelector('#fileToUpload');
input.addEventListener('change',preview);
function preview(){
    var fileObject = this.files[0];
    var fileReader = new FileReader();
    fileReader.readAsDataURL(fileObject);
    fileReader.onload = function(){
        var result = fileReader.result;
        var img = document.querySelector('#preview');
        img.setAttribute('src',result);
    }
}
const url = 'http://127.0.0.1:5000/api/image_pridiction';
const form = document.querySelector('form');

form.addEventListener('submit', e => {
    e.preventDefault();

    const files = document.querySelector('[type=file]').files;
    const formData = new FormData();

    for (let i = 0; i < files.length; i++) {
        let file = files[i];

        formData.append('imagefile', file);
    }

    fetch(url, {
        method: 'POST',
        body: formData
    }).then(response => {
        return response.text();
    }).then(data => {
        document.getElementById("result").innerHTML = data; 
        console.log(data);
    });
});
function btn(){
    var text;
    var color = data.value;
    if (color == "ultrasonic")
    {
        text = "hii \n I am ultrasonic";
        document.getElementById("result").innerHTML = text;
    }
}