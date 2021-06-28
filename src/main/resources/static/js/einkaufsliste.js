
var list = document.ArtikelController






    function printList(list) {
        var container = document.querySelector("#container");
        for (var i = 0; i < list.length; i++) {
            const div = document.createElement("li");
            const input = document.createElement("input");
            input.type = "checkbox";
            input.addEventListener("change", this.changeColor(list[i].productId.toString()));
            div.innerHTML = list[i];
            container.appendChild(div);
            div.appendChild(input);
        }
    }

    printList(list);