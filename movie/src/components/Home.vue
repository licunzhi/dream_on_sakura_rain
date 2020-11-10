<template>
  <el-container style="height: 100%; width: 100%">
    <el-header style="z-index: 111">
      <el-menu
        :router="enable"
        :default-active="activityMenu"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <div class="logo">
          <img :src="logo" alt="LOGO">
        </div>
        <div class="logo">
          <span class="logoName">Sakura影院</span>
        </div>
        <template v-for="menu in menus">
          <el-menu-item v-if="menu.type === 1" :index="menu.index" :key="menu.index">
            {{ menu.name }}
          </el-menu-item>

          <el-submenu v-if="menu.type === 2" :index="menu.index" :key="menu.index">
            <template slot="title">{{ menu.name }}</template>

            <template v-if="menu.subMenu.length > 0" v-for="submenu in menu.subMenu">
              <el-menu-item v-if="submenu.type === 1" :index="submenu.index" :key="submenu.index">
                {{ submenu.name }}
              </el-menu-item>
              <el-submenu v-if="submenu.type === 2" :index="submenu.index" :key="submenu.index">
                <template slot="title">{{ submenu.name }}</template>

                <el-menu-item v-for="subsub in submenu.subMenu" :index="subsub.index" :key="subsub.index">
                  {{ subsub.name }}
                </el-menu-item>
              </el-submenu>
            </template>

          </el-submenu>
        </template>

        <div class="search_movie">
          <el-form :inline="enable" class="demo-form-inline">
            <el-form-item label="电影名称">
              <el-input placeholder="电影名称"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="sdcMethodTest">查询</el-button>
            </el-form-item>
          </el-form>
        </div>

        <!-- 最右侧边的用户头像 -->
        <div class="avatar">
          <div v-if="userStore && userStore['user_name']" class="demo-basic--circle"
               @click="centerDialogVisible = true">
            <el-popover
              placement="top-start"
              width="150"
              :title="userStore['user_name']"
              trigger="hover">
              <p>账户余额：<span style="color: red">{{userStore['account_money']}}￥</span></p>
              <el-avatar slot="reference" :size="avSize" :src="userStore['user_avatar']"></el-avatar>
            </el-popover>
          </div>
          <div v-else class="demo-basic--circle" @click="dialogFormVisible = true">
            <el-avatar :size="avSize">登录</el-avatar>
          </div>
        </div>
      </el-menu>
    </el-header>

    <el-container style="height: 100%; width: 100%; overflow: visible">
      <router-view></router-view>
    </el-container>

    <el-footer class="footer">
      <div>
        <p>关于Sakura:
          <a href="#">关于我们</a>
          <span>|</span>
          <a href="#">管理团队</a>
          <span>|</span>
          <a href="#">投资关系</a>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;友情链接 :
          <a href="#">美团网</a>
          <span>|</span>
          <a href="#">格拉网</a>
          <span>|</span>
          <a href="#">美团下载</a>
          <span>|</span>
          <a href="#">欢喜首映</a>
        </p>
        <p>
          商务合作邮箱：2718272293@qq.com
          客服电话：18375335212
          违法和不良信息举报电话：17721525212
          <br>
          投诉举报邮箱：2718272293@qq.com
          舞弊线索举报邮箱：2718272293@qq.com
        </p>
        <p>
          ©2019
          Sakura电影 sakura.com
          <a href="#" target="_blank">京ICP证######号</a>
          <a href="#" target="_blank">京ICP备1xxxxxxxxx号-1</a>
          <a href="#" target="_blank">京公网安备 XXXXXXXXXXXXXXXXXX号</a>
          <a href="#" target="_blank">网络文化经营许可证</a>
          <a href="#" target="_blank">电子公告服务规则</a>
        </p>
        <p>南京Sakura文化传媒有限公司</p>
      </div>
    </el-footer>
    <!--login form start-->
    <el-dialog
      :center="enable"
      width="20%"
      title="用户登陆"
      :visible.sync="dialogFormVisible">
      <el-form :model="userInfo" ref="userInfo">
        <el-form-item label="手机号"
                      :rules="[
                              { required: true, message: '手机号码不能为空', trigger: 'blur'},
                              { type: 'number', message: '只允许输入数字', trigger: 'blur'},
                              { pattern: /^1[3456789]\d{9}$/, message: '请填入正确的手机号码', trigger: 'blur'}
                            ]"
                      prop="phone">
          <el-input v-model.number="userInfo.phone" maxlength="11" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" :rules="passwordValidate">
          <el-input v-model="userInfo.password" type="password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取&nbsp;&nbsp;&nbsp;消</el-button>
        <el-button type="danger" @click="restFormFiles('userInfo')">重&nbsp;&nbsp;&nbsp;置</el-button>
        <el-button type="primary" @click="loginEvent('userInfo')">登&nbsp;&nbsp;&nbsp;陆</el-button>
      </div>
    </el-dialog>
    <!--login form end-->
    <el-dialog
      title="注销"
      :visible.sync="centerDialogVisible"
      width="20%"
      center>
      <span>确认退出登录？</span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="loginOut()">确 定</el-button>
  </span>
    </el-dialog>
  </el-container>
</template>

<script>
import {mapMutations, mapGetters} from 'vuex'
import ImageConst from './constants/ImageConst'
import Menu from './constants/Menu'
import base64 from '@/service/base64'

export default {
  name: 'Home',
  data () {
    return {
      enable: true,
      msg: 'This is movie Home page',
      logo: ImageConst.logo,
      menus: Menu.menus,
      activityMenu: Menu.menus[0].index,
      logout: false,
      avSize: 'large',
      dialogFormVisible: false,
      userInfo: {},
      width: '10rem',
      passwordValidate: [{
        required: true, message: '密码不能为空'
      }],
      centerDialogVisible: false
    }
  },
  created () {
    if (this.$route.path !== '/' && this.$route.path !== '') {
      this.activityMenu = this.$route.path
    }
  },
  computed: {
    ...mapGetters({
      userStore: 'getUser'
    })
  },
  methods: {
    ...mapMutations({
      storeUserInfo: 'initUserInformation',
      removeUserInfo: 'removeUserInformation'
    }),
    handleSelect (key, keyPath) {
      console.error(key, keyPath)
    },
    // 登录点击事件
    loginEvent (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('/sakura/Login/loginAction', {
            phone: this.userInfo.phone,
            password: this.userInfo.password
          }).then((response) => {
            if (response['data'].code === 200) {
              const userObj = response['data']['data']
              this.dialogFormVisible = false
              this.$message({
                message: '登录成功,用户-' + userObj['user_name'],
                type: 'success'
              })
              // 存储用户信息
              this.storeUserInfo({
                user_name: userObj['user_name'],
                phone: userObj['phone'],
                user_avatar: userObj['user_avatar'],
                user_id: userObj['user_id'],
                account_money: userObj['account_money']
              })
            } else {
              this.$message({
                message: '登录失败，确认登录信息后重试',
                type: 'error'
              })
            }
            return response
          }).catch((exception) => {
            this.$message({
              message: '登录失败，确认登录信息后重试',
              type: 'error'
            })
          })
        } else {
          return false
        }
      })
    },
    // 重置属性
    restFormFiles (formName) {
      this.$refs[formName].resetFields()
    },
    loginOut () {
      this.removeUserInfo()
      this.centerDialogVisible = false
    },
    // asiaInfo felix request test
    sdcMethodTest () {
      const params = {
        handler: 'DistrFileStoreHandler',
        action: 'getDistrFileStore',

        fileType: '',
        filePath: '',

        currentPage: 1,
        pageSize: 10
      }
      const aa = JSON.stringify(params)
      const value = base64.encode(base64.utf16to8(aa))
      this.axios.post('/aus/felix', this.qs.stringify({'json': value}), {headers: {'Content-Type': 'application/x-www-form-urlencoded'}}).then((response) => {
        console.error(response.data)
        return response
      }).catch((exception) => {
        return exception
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .left_float {
    float: left;
  }

  .right_float {
    float: right;
  }

  .logo {
    float: left;
  }

  .logo img {
    padding-top: 0.2rem;
    border: none;
    height: 1.6rem;
  }

  .avatar {
    float: right;
    margin-right: 1rem;
  }

  .demo-basic--circle {
    margin-top: 0.3rem;
  }

  .logout a {
    color: #fff;
    text-decoration: none;
    font-size: 0.1rem;
  }

  .logoName {
    color: #eee;
    text-align: center;
    font-size: 1.3rem;
    margin-right: 1rem;
  }

  /*search form position*/
  .search_movie {
    position: absolute;
    margin-left: 70%;
    margin-top: 0.3rem
  }

  /*bottom information*/
  footer.footer {
    /*height: 4rem!important;*/
    height: auto !important;
    background-color: #545c64;
    color: #98A7B5;
    font-size: 0.3rem;
    z-index: 111;
  }

  footer.footer a {
    color: #ef4238;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }
</style>
