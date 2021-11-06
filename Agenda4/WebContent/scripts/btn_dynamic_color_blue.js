(()=>{
let btnElements = document.getElementsByClassName("btn_blue");
for(let i = 0; i < btnElements.length; i++){
    btnElements[i].addEventListener('mouseover', colorLightnessDown);
    btnElements[i].addEventListener('mouseout', colorLightnessUp);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
 }
 async function colorLightnessUp() {
    for (let i = 60; i < 90; i++) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(240, 100%, " + i + "%)";
    }
 }

 async function colorLightnessDown() {
    for (let i = 90; i > 50 ; i--) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(240, 100%, " + i + "%)";
    }
 }
})()
 
 
