// Create a Vue application
const app = Vue.createApp({})

// Define a new global component called button-counter
app.component('input-einkaufsliste', {
    data() {
        return {
            nameField: '',
            item: [],
        }
    },


    methods: {
        loadProducts(){
            axios.get('/products').then(response => this.item = response.data())
        },
save(){
    axios.post('/createProdukt',{
            productname: this.nameField
        }).then((response) =>{
            this.nameField = '';
            this.$ref.nameInput.focus();
            this.loadProducts();
    }, (error)=>{
            console.log("nicht gerspeichert")
    });
}

    },
    mounted: function (){
        this.loadProducts();
    },


    template: `
 <div>
 <input v-model="nameField" placeholder="Artikel" ref="nameInput">
 <button type="button" @click="save()">Hinzufügen</button>
</div> 
<div>
<h2>Einkaufsliste</h2>
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
<td>{{ProductEntity.productname}}</td>
</tr>
<tr>
<td>{{nameField}}</td>
</tr>
</tbody>
</table>
</div>`
})

app.mount('#input-einkaufsliste');