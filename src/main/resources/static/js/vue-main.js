
import VueTest from './vue-test.js';
import VuePinWall from './vue-pinwall.js';


const app = Vue.createApp({});
app.component('vue-test', VueTest);
app.component('vue-pinwall', VuePinWall);

app.mount('#app');