(()=>{
let btnElements = document.getElementsByClassName("btn_green");
for(let i = 0; i < btnElements.length; i++){
    btnElements[i].addEventListener('mouseover', colorLightnessDown);
    btnElements[i].addEventListener('mouseout', colorLightnessUp);
}

let lines = document.getElementsByClassName("line_table");
for(let i = 0; i < lines.length; i++){
    lines[i].addEventListener('mouseover', destacar);
}

for(let i = 0; i < lines.length; i++){
    lines[i].addEventListener('mouseout', desDestacar);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
 }
 async function colorLightnessUp() {
    for (let i = 40; i < 70; i++) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(147, 50%, " + i + "%)";
    }
 }

 async function colorLightnessDown() {
    for (let i = 70; i > 40 ; i--) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(147, 50%, " + i + "%)";
    }
 }
 
 function destacar(){
 	this.style.backgroundColor = "hsl(240, 100%, 90%)";
 }
 
 function desDestacar(){
 	this.style.backgroundColor = "white"; 
 }
 
})()
 
 
 
