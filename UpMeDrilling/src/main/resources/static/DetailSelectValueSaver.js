const selectedDetail = document.getElementById("detail");
selectedDetail.addEventListener("change", function () {
    localStorage.setItem("detail", this.value);
});
let savedDetail = localStorage.getItem("detail");
if (savedDetail) selectedDetail.value = savedDetail;

