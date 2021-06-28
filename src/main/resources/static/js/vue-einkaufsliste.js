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
 <input type="checkbox" v-model="checker[String(ProduktEntity.productId)]" v-bind:value="status" @change="changeBoolean(ProduktEntity.productId);changeColor(String(ProduktEntity.productId))"> 
         </tr>
    </tbody>         
</table>
</div>
<div>
<button type="button" @click="deleteProducts()">Einkaufsliste leeren</button>
</div>

`,






    data() {
        return {
            tablerowsForProducts:[],
            nameField: '',
            item: [],
            checker: [],
            check: false
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

        changeBoolean: function (id){
            if(this.check === true){
                this.check = false;
            }else{
                this.check = true;
            }
        },

        changeColor: function(id){
            let checkString = String(this.check)
          axios.post('/artikelgrau/'+id+'/'+checkString).then((response) => {
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