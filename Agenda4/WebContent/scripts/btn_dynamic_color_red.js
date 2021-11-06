(()=>{
let btnElements = document.getElementsByClassName("btn_red");
for(let i = 0; i < btnElements.length; i++){
    btnElements[i].addEventListener('mouseover', colorLightnessDown);
    btnElements[i].addEventListener('mouseout', colorLightnessUp);
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
 }
 async function colorLightnessUp() {
    for (let i = 40; i < 70; i++) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(0, 59%, " + i + "%)";
    }
 }

 async function colorLightnessDown() {
    for (let i = 70; i > 40 ; i--) {        
       await sleep(15);
       this.style.backgroundColor = "hsl(0, 59%, " + i + "%)";
    }
 }
})()
 
 
