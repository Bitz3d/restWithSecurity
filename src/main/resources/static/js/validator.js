var uploadField = document.getElementById("file");
console.log('sasasas')
uploadField.onchange = function() {
    if(this.files[0].size > 307200){
       alert("File is too big!");
       this.value = "";
    };
};