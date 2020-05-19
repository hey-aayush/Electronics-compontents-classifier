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

function filterFunction() {
    var input, filter, ul, li, a, i,txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    ul = document.getElementById("myDropdown");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
      txtValue = a.textContent || a.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        li[i].style.display = "";
      } else {
        li[i].style.display = "none";
      }
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
    
    var text;
    var text1;
    var text2;
    var color = data;
    if (color == "memory-chip")
    {
        text = "Name :Memory-chip";
        document.getElementById("result1").innerHTML = text;
        text1 = "A memory chip is an integrated circuit made out of millions of capacitors and transistors that can store data or can be used to process code. Memory chips can hold memory either temporarily through random access memory (RAM), or permanently through read only memory (ROM).";
        document.getElementById("result2").innerHTML = text1;
       
    }
    if (color == "potentiometer")
    {
        text = "Name :Potentiometer";
        document.getElementById("result1").innerHTML = text;
        text1 = "A potentiometer is a three-terminal resistor with a sliding or rotating contact that forms an adjustable voltage divider. If only two terminals are used, one end and the wiper, it acts as a variable resistor or rheostat.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "multipexer")
    {
        text = "Name :Multiplexer";
        document.getElementById("result1").innerHTML = text;
        text1 = "In electronics, a multiplexer (or mux; spelled sometimes as multiplexor), also known as a data selector, is a device that selects between several analog or digital input signals and forwards it to a single output line";
        document.getElementById("result2").innerHTML = text1;
       
    }
    if (color == "buzzer")
    {
        text = "Name :Buzzer";
        document.getElementById("result1").innerHTML = text;
        text1 = "A buzzer or beeper is an audio signalling device, which may be mechanical, electromechanical, or piezoelectric (piezo for short). Typical uses of buzzers and beepers include alarm devices, timers, and confirmation of user input such as a mouse click or keystroke";
        document.getElementById("result2").innerHTML = text1;
       
    }
    if (color == "camera")
    {
        text = "Name :Camera";
        document.getElementById("result1").innerHTML = text;
        text1 = "An image sensor or imager is a sensor that detects and conveys information used to make an image. It does so by converting the variable attenuation of light waves (as they pass through or reflect off objects) into signals, small bursts of current that convey the information. The waves can be light or other electromagnetic radiation. ";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "cartidge-fuse")
    {
        text = "Name :Cartidge-fuse";
        document.getElementById("result1").innerHTML = text;
        text1 = "All fuses, including cartridge fuses, are the weak link in an electrical circuit. Inside the fuse is a metal strip that is connected to both metal ends of the fuse body.";
        document.getElementById("result2").innerHTML = text1;
       
    }
    if (color == "clip-lead")
    {
        text = "Name : Clip-lead";
        document.getElementById("result1").innerHTML = text;
        text1 = "A jump wire (also known as jumper wire, or jumper) is an electrical wire, or group of them in a cable, with a connector or pin at each end (or sometimes without them – simply tinned), which is normally used to interconnect the components of a breadboard or other prototype or test circuit, internally or with other equipment or components, without soldering.[1]";
        document.getElementById("result2").innerHTML = text1;
        
    }if (color == "DTH22")
    {
        text = "Name :DTH22";
        document.getElementById("result1").innerHTML = text;
        text1 = "AM2303 output calibrated digital signal. It utilizes exclusive digital-signal-collecting-technique and humidity sensing technology, assuring its reliability and stability.Its sensing elements is connected with 8-bit single-chip";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "filament")
    {
        text = "Name :Filament";
        document.getElementById("result1").innerHTML = text;
        text1 = "(in a light bulb or other incandescent lamp) the threadlike conductor, often of tungsten, in the bulb that is heated to incandescence by the passage of current.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "flame_sensor")
    {
        text = "Name :Flame sensor";
        document.getElementById("result1").innerHTML = text;
        text1 = "A flame-sensor is one kind of detector which is mainly designed for detecting as well as responding to the occurrence of a fire or flame. The flame detection response can depend on its fitting. It includes an alarm system, a natural gas line, propane & a fire suppression system.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "induction-coil")
    {
        text = "Name :Induction coil";
        document.getElementById("result1").innerHTML = text;
        text1 = "An induction coil consists of two coils of insulated wire wound around a common iron core (M). One coil, called the primary winding (P), is made from relatively few (tens or hundreds) turns of coarse wire.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "ir_sensor_module")
    {
        text = "Name :IR sensor";
        document.getElementById("result1").innerHTML = text;
        text1 = "IR detectors are little microchips with a photocell that are tuned to listen to infrared light. They are almost always used for remote control detection - every TV and DVD player has one of these in the front to listen for the IR signal from the clicker.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "LED")
    {
        text = "Name :LED";
        document.getElementById("result1").innerHTML = text;
        text1 = "";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "LPG")
    {
        text = "Name :";
        document.getElementById("result1").innerHTML = text;
        text1 = "A light-emitting diode (LED) is a semiconductor light source that emits light when current flows through it. Electrons in the semiconductor recombine with electron holes, releasing energy in the form of photons. The color of the light (corresponding to the energy of the photons) is determined by the energy required for electrons to cross the band gap of the semiconductor.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "moisture_sensor")
    {
        text = "Name :Moisture sensor";
        document.getElementById("result1").innerHTML = text;
        text1 = "Soil moisture sensors measure the volumetric water content in soil.[1] Since the direct gravimetric measurement of free soil moisture requires removing, drying, and weighing of a sample, soil moisture sensors measure the volumetric water content indirectly by using some other property of the soil, such as electrical resistance, dielectric constant";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "MPU6050_SENSOR")
    {
        text = "Name :MPU";
        document.getElementById("result1").innerHTML = text;
        text1 = "The MPU-6050™ parts are the world’s first MotionTracking devices designed for the low power, low cost, and high-performance requirements of smartphones, tablets and wearable sensors.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "raspberry_pi")
    {
        text = "Name :Raspberry pi";
        document.getElementById("result1").innerHTML = text;
        text1 = "The Raspberry Pi (/paɪ/) is a series of small single-board computers developed in the United Kingdom by the Raspberry Pi Foundation to promote teaching of basic computer science in schools and in developing countries.[7][8][9] The original model became far more popular than anticipated,[10] selling outside its target market for uses such as robotics.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "pulse-generator")
    {
        text = "Name :Pulse generator";
        document.getElementById("result1").innerHTML = text;
        text1 = "A pulse generator is either an electronic circuit or a piece of electronic test equipment used to generate rectangular pulses. Pulse generators are used primarily for working with digital circuits, related function generators are used primarily for analog circuits.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "relay")
    {
        text = "Name :Relay";
        document.getElementById("result1").innerHTML = text;
        text1 = "Relays are the switches which aim at closing and opening the circuits electronically as well as electromechanically. It controls the opening and closing of the circuit contacts of an electronic circuit. When the relay contact is open (NO), the relay isn't energize with the open contact";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "stabilizer")
    {
        text = "Name :";
        document.getElementById("result1").innerHTML = text;
        text1 = "The main function of a stabilizer is to make the output voltage that feeds the equipments connected to it as much as possible equivalent to the ideal electrical power supply, ensuring that the oscillations in electrical power are offset, and its output maintain a stable value";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "transistor")
    {
        text = "Name :Transistor";
        document.getElementById("result1").innerHTML = text;
        text1 = "A transistor is a semiconductor device used to amplify or switch electronic signals and electrical power. It is composed of semiconductor material usually with at least three terminals for connection to an external circuit. A voltage or current applied to one pair of the transistor's terminals controls the current through another pair of terminals. ";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "ultrasonic sensor")
    {
        text = "Name :Ultrasonic";
        document.getElementById("result1").innerHTML = text;
        text1 = "An ultrasonic sensor is an instrument that measures the distance to an object using ultrasonic sound waves. An ultrasonic sensor uses a transducer to send and receive ultrasonic pulses that relay back information about an object's proximity.";
        document.getElementById("result2").innerHTML = text1;
        
    }

    if (color == "shunt")
    {
        text = "Name :Shunt";
        document.getElementById("result1").innerHTML = text;
        text1 = "In electronics, a shunt is a device that creates a low-resistance path for electric current, to allow ... 50 A shunt resistor, with provision for four-terminal sensing.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "arduino_mega")
    {
        text = "Name :arduino_mega";
        document.getElementById("result1").innerHTML = text;
        text1 = "The Arduino Mega 2560 is a microcontroller board based on the ATmega2560. It has 54 digital input/output pins (of which 15 can be used as PWM outputs), 16 analog inputs, 4 UARTs (hardware serial ports), a 16 MHz crystal oscillator, a USB connection, a power jack, an ICSP header, and a reset button.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "arduino_nano")
    {
        text = "Name :arduino_nano";
        document.getElementById("result1").innerHTML = text;
        text1 = "The Arduino Nano is a small, complete, and breadboard-friendly board based on the ATmega328 (Arduino Nano 3.x). It has more or less the same functionality of the Arduino Duemilanove, but in a different package. It lacks only a DC power jack, and works with a Mini-B USB cable instead of a standard one.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    if (color == "arduino_uno")
    {
        text = "Name :arduino_uno";
        document.getElementById("result1").innerHTML = text;
        text1 = "The Arduino UNO is the best board to get started with electronics and coding. If this is your first experience tinkering with the platform, the UNO is the most robust board you can start playing with. The UNO is the most used and documented board of the whole Arduino family.";
        document.getElementById("result2").innerHTML = text1;
        
    }
    });


});

    