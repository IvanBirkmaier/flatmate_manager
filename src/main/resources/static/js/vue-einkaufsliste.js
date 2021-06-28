export default {
    props: ['title'],
    template: `

<div>
<h2>Einkaufsliste</h2>
</div>
<div>
 <input v-model="nameField" placeholder="Artikel" ref="nameInput">
 <button type="button" @click="save()">Hinzufügen</button>
</div> 

<div>
<table>
    <thead>
    </thead>
    <tbody>
      <tr v-if="item.length === 0">
             <td colspan="2">Keine Artikel</td>
    </tr>
        </tr>
        <tr v-for="ProduktEntity in item" v-bind:class="{clear: ProduktEntity.completed}">
         <button type="button" class="clear" @click="deleteOneProduct(String(ProduktEntity.productId))">X</button>
                                    {{ProduktEntity.productname}}
 <input type="checkbox" v-model="checker[String(ProduktEntity.productId)]"  @change="changeColor(String(ProduktEntity.productId))"> 
         </tr>
    </tbody>         
</table>
</div>
<div>
<button v-if="item.length !== 0" type="button" @click="deleteProducts()">Einkaufsliste leeren</button>
</div>

`,






    data() {
        return {
            tablerowsForProducts:[],
            nameField: '',
            item: [],
            checker: [],
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

        changeColor: function(id){
            axios.post('/artikelgrau/'+id).then((response) => {
              this.loadProducts();
          })
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
}