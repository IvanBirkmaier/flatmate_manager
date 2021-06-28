
export default {
    props: ['title'],
    template: `
<div>
    <h2>To-Do</h2>
</div>

<div>
    <input v-model="postField" placeholder="TO-DO" ref="postInput">
    <button type="button" @click="save()">Hinzufügen</button>
</div> 
<div>

<div>
    <table>
        <thead>
       </thead>
        <tbody>

            <tr v-if="item.length === 0">
                <td colspan="2">Alles erledigt:)</td>
            </tr>      
            <tr v-for="PinnwandEntity in item">
                    <button type="button" class="clear" @click="deleteOnePost(String(PinnwandEntity.pinwallId))">X</button>
                {{PinnwandEntity.post}}
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

                console.log('nicht gespeichert');
            });
        },
    },
    mounted: function () {
        this.loadPost();
    }
}
