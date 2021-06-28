import { mount } from '@vue/test-utils'
import VueEinkaufsliste from './vue-einkaufsliste.js'

global.axios = {
    get(){return Promise.resolve({data: []})},
    post(){return Promise.resolve('value')}
}

test('Test für leere item List in einkauflisten vue-Template', () => {
    const wrapper = mount(VueEinkaufsliste);
except(wrapper.text()).toContain('Keine Artikel');
})