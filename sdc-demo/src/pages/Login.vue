<template>
  <div class="sdc-login">
    <div class="login-title">
      <h1>SDC_DEMO</h1>
    </div>
    <div class="login-form">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" class="demo-ruleForm">
        <el-form-item label="开启路由守卫验证" label-width="150px" >
          <el-switch v-model="ruleForm.Cookie"></el-switch>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {mapGetters, mapMutations} from 'vuex'

export default {
  name: 'Login',
  data () {
    return {
      ruleForm: {
        Cookie: ''
      },
      rules: {
        Cookie: [
          {required: true, message: '必填', trigger: 'blur'}
        ]
      }
    }
  },
  computed: {

  },
  methods: {
    ...mapMutations('SdcUserStore', [
      'setCookie',
      'setUserInfo'
    ]),

    ...mapGetters('SdcUserStore', [
      'getCookie',
      'getUserInfo'
    ]),

    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.setCookie(this.ruleForm.Cookie)
          this.messageTips(this.ruleForm.Cookie ? 'success' : 'error', this.ruleForm.Cookie ? '开启路由验证' : '关闭路由验证')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    /* 一句话展示提示 */
    messageTips: function (type, message) {
      this.$message({
        showClose: true,
        message: message,
        type: type,
        duration: '3000'
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .sdc-login {
    background: #e5eaf4;
    height: 100%;
    width: 100%;
    padding: 0;
    margin: 0;
  }

  .login-title {
    padding: 50px 0
  }

  .login-title h1 {
    margin: 0;
    padding: 0;
  }

  .login-form {
    width: 10%;
    margin: 0 45% auto;
  }

</style>
