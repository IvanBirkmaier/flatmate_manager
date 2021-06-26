
export default {
    props: ['title'],
    template: `



<div>
    <input v-model="postField" placeholder="Kommentar" ref="postInput">
    <button type="button" @click="save()">Posten</button>
</div> 
<div>
    <h2>Pinwand</h2>
</div>

<div>
    <table>
        <thead>
       </thead>
        <tbody>
            <tr v-if="item.lengh === 0">
                <td colspan="2">Pinwand</td>
            </tr>      
            <tr v-for="PinWandEntity in item">
                    <button type="button" class="clear" @click="deleteOnePost(String(PinWandEntity.productId))">X</button>
                {{PinWandEntity.post}}
         </tr>
        </tbody> 
    </table>
</div>`,

    data() {
        return {
            postField: '',
            item: [],
        };
    },


    methods: {


        loadPost() {
            axios.get('/findposts').then(response => (this.item = response.data))
        },

        deleteOnePost(id){
            axios.delete('/postloeschen/'+id).then(response => (this.loadPost()))
        },
        save() {
            axios.post('/posthinzufuegen', {
                post: this.postField
            }).then((response) => {
                this.postField = '';
                this.$refs.postInput.focus();
                this.loadPost();
            }, (error) => {
                console.log('nicht gerspeichert');
            });
        },
    },
    mounted: function () {
        this.loadProducts();
    }
}
