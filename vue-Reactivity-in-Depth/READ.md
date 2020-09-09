# Introduce

https://cn.vuejs.org/v2/guide/reactivity.html  

当你把一个普通的 JavaScript 对象传入 Vue 实例作为 data 选项，  
Vue 将遍历此对象所有的 property，并使用 Object.defineProperty 把这些 property 全部转为 getter/setter。  
Object.defineProperty 是 ES5 中一个无法 shim 的特性，这也就是 Vue 不支持 IE8 以及更低版本浏览器的原因。  

由于 JavaScript 的限制，Vue 不能检测数组和对象的变化

Vue 不允许动态添加根级别的响应式 property  
vm.$set  Object.assign()  


Vue 不能检测以下数组的变动：  
```javascript
var vm = new Vue({
  data: {
    items: ['a', 'b', 'c']
  }
})
vm.items[1] = 'x' // 不是响应性的
vm.items.length = 2 // 不是响应性的
```
解决办法  
Vue.set(vm.items, indexOfItem, newValue)  
vm.items.splice(indexOfItem, 1, newValue)   

vm.$set(vm.items, indexOfItem, newValue)  
vm.items.splice(newLength)  

这样的限制在背后是有其技术原因的，它消除了在依赖项跟踪系统中的一类`边界情况`，
也使 Vue 实例能更好地配合类型检查系统工作。但与此同时在代码可维护性方面也有一点重要的考虑：
data 对象就像组件状态的结构 (schema)。提前声明所有的响应式 property，可以让组件代码在未来修改或给其他开发人员阅读时更易于理解。

