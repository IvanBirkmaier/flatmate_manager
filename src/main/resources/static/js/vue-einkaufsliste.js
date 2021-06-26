export default {
    props: ['title'],
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
            <div v-else="ProduktEntity.completed === 0">
            <button type="button" class="clear" @click="deleteOneProduct(String(ProduktEntity.productId))">X</button>
                {{ProduktEntity.productname}}
                <button type="button" @click="changeColor(String(ProduktEntity.productId))">Gekauft</button>
            </div>
             <div  v-if="ProduktEntity.completed === 1">
                <button type="button" class="clear" @click="deleteOneProduct(String(ProduktEntity.productId))">X</button>
             {{ProduktEntity.productname}} 
                <button type="button" class="clear" @click="changeColor(String(ProduktEntity.productId))">Gekauft</button>
            </div>
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
                console.log('nicht gespeichert');
            });
        },
    },
    mounted: function () {
        this.loadProducts();
    }
}