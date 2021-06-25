// Create a Vue application
const app = Vue.createApp({})

// Define a new global component called button-counter
app.component('input-einkaufsliste', {
    template: `
 <div>
 <input v-model="nameField" placeholder="Artikel" ref="nameInput">
 <button type="button" @click="save()">Hinzufügen</button>
</div> 

<div>
<h2>Einkaufsliste</h2>
</div>
<div>
<table>
    <thead>
        <tr>
            <th>Artikel</th>
        </tr>
    </thead>
    <tbody>
        <tr v-if="item.lengh === 0">
             <td colspan="2">Keine Artikel</td>
        </tr>
        <tr v-for="ProduktEntity in item">
              <button type="button"  @click="deleteOneProduct(String(ProduktEntity.productId))">Entfernen</button>
              {{ProduktEntity.productname}}
           <button type="button" @click="changeColor(String(ProduktEntity.productId))">Gekauft</button>
         </tr>
    </tbody>
</table>
</div>
<div>
<button type="button" @click="deleteProducts()">Einkaufsliste leeren</button>
</div>`,

    data() {
        return {
            nameField: '',
            item: [],
        };
    },


    methods: {
        loadProducts() {
            axios.get('/findartikel').then(response => (this.item = response.data))
        },
        deleteProducts(){
          axios.post('/alleartikellöschen').then(response => (this.loadProducts()))
        },

        deleteOneProduct(id){
            axios.delete('/artikelloeschen/'+id).then(response => (this.loadProducts()))
        },

        changeColor(id){
          axios.post('/artikelgrau/'+id).then(response => (this.loadProducts()))
        },
        save() {
            axios.post('/artikelhinzufuegen', {
                productname: this.nameField
            }).then((response) => {
                this.nameField = '';
                this.$refs.nameInput.focus();
                this.loadProducts();
            }, (error) => {
                console.log('nicht gerspeichert');
            });
        },
    },
    mounted: function () {
        this.loadProducts();
    }
});


app.mount('#input-einkaufsliste');