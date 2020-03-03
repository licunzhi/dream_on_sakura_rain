<template>
  <div class="body-content">

  </div>
</template>

<script>
export default {
  name: 'Morning',
  data () {
    return {
      answers: {}
    }
  }
}
</script>

<style scoped>
.body-content {
  margin: 10px 20px;
  font-size: 20px;
}
strong {
  color: red;
}
.tips span a{
  text-decoration: none;
  padding: 10px;
  display: block;
  color: white;
}
.active {
  background-color: green;
}
.inactive {
  background-color: #8c939d;
}
.el-divider {
  margin: 0px;
}
</style>
