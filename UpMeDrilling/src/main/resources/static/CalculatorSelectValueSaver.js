const a = document.getElementById("a");
a.addEventListener("change", function () {
    localStorage.setItem("a", this.value);
});
let savedA = localStorage.getItem("a");
if (savedA) a.value = savedA;



const b = document.getElementById("b");
b.addEventListener("change", function () {
    localStorage.setItem("b", this.value);
});
let savedB = localStorage.getItem("b");
if (savedB) b.value = savedB;

