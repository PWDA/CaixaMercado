var icons = document.querySelectorAll(".icons");

icons.forEach(function(icon){
    this.addEventListener("mouseover", function(){
       console.log(icon);
    })
})