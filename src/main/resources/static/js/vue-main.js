
import VueTest from './vue-einkaufsliste.js';
import VuePinWall from './vue-pinnwand.js';


const app = Vue.createApp({});
app.component('vue-einkaufsliste', VueEinkaufsliste);
app.component('vue-pinnwand', VuePinnwand);

app.mount('#app');