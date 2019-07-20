<template>
  <div>order</div>
</template>

<script>
export default {
  name: 'Order',
  data: function () {
    return {
      orderList: []
    }
  },
  created: function () {
    this.getAllOrderInfo()
  },
  methods: {
    /* 所有的订单信息 */
    getAllOrderInfo: function () {
      this.$axios.post('/', {

      }).then(response => {

      }).catch(exception => {

      })
    }
  }
}
</script>

<style scoped>

</style>
