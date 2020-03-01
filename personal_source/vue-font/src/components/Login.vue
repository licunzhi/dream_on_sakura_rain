<template>
  <div style="width: 500px; margin: 0 auto;">
    <h1>这是登录页面  没有经过校验的所有的请求都会到此页面</h1>

    <!--个人推荐写法 能满足大部分需求-->
    <h3>一般表单校验以及写法</h3>
    <el-form :model="loginForm" status-icon ref="loginForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="手机号" prop="phone" :rules="checkPhone">
        <el-input v-model.number="loginForm.phone" maxlength="11" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password" :rules="checkPw">
        <el-input type="password" v-model.number="loginForm.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="loginAction('loginForm')">提交</el-button>
        <el-button @click="restAction('loginForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      checkPhone: [
        {required: true, message: '手机号码不能为空', trigger: 'blur'},
        {type: 'number', message: '只允许输入数字', trigger: 'blur'},
        {pattern: /^1[3456789]\d{9}$/, message: '请填入正确的手机号码', trigger: 'blur'}
      ],
      checkPw: [
        {required: true, message: '密码不允许为空', trigger: 'blur'}
      ],
      loginForm: {
        phone: '',
        password: ''
      },
      ruleForm: {
        pass: '',
        checkPass: '',
        age: ''
      }
    }
  },
  methods: {
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    loginAction (formName) {
      this.$router.push('/main')
    },
    restAction (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style scoped>

</style>
