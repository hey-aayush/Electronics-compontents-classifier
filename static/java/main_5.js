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
const url = "{{ url_for("/image_prediction") }}"
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
    
    var text;
    var color = data;
    if (color == "memory-chip")
    {
        text = "hii \n I am ultrasonic";
        document.getElementById("result1").innerHTML = text;
        console.log(text);
    }
    });


});

    