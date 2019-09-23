<template>
<div class="set-content">
  <div class="cinema_info">
    <h3>{{$route.params.item['cinema_name']}}({{$route.params.item['hall_name']}})</h3>
  </div>
  <div class="clearfix">
    <p style="border-bottom: 5px solid red; padding-left: 5px" class="left">票价:</p>
    <span class="left" style="color: red; margin-top:0.5rem; padding-right: 10px">￥{{$route.params.item['movie_price']}}</span>
    <p class="left">可选座位:</p>
    <span :style="setIco" class="left tips"></span>
    <p class="left">已选座位:</p>
    <span :style="setToChoseIco" class="left tips"></span>
    <p class="left">已售座位:</p>
    <span :style="setChoseIco" class="left tips"></span>
  </div>
  <div class="clearfix">
    <div class="left limit-width">
      <span v-for="i in 10" :key="i">{{i}}</span>
    </div>
    <div class="left screen-class">
      <div class="screen-location">荧幕中央</div>
      <div class="screen-ico"></div>
      <div class="set-container">
        <div v-for="row in 10" :key="row" class="screen-set">
          <span :style="setsChoose.indexOf(row+'-'+clo) >= 0 ? setChoseIco : setIco" v-for="(clo,index) in 20" :key="clo * index" @click="setsChoose.indexOf(row+'-'+clo) >= 0 ? '' : chooseThis($event, row, clo)"></span>
        </div>
      </div>
    </div>
  </div>
  <!--已选座位-->
  <div class="clearfix">
    <div class="bottom-tips">
        <p class="left">已选座位: </p>
        <span v-for="item in setArr" :key="item" :style="setToChoseIco" class="left tips">{{item.row}}排{{item.clo}}座</span>
    </div>
  </div>
  <div class="right right-margin">
    <span style="margin-right: 3rem">总价:<i style="color: red">￥{{totalMoney}}</i></span>
    <el-button v-if="setArr.length > 0" type="danger" round @click="showPayDialog()">确认</el-button>
    <el-button v-else type="danger" disabled round>确认</el-button>
  </div>

  <el-dialog title="填写支付信息" :visible.sync="payDialog" width="600px">
    <el-form :model="pay">
      <el-form-item label="支付账号">
        <el-input v-model="pay.user_account" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="支付密码">
        <el-input type="password" v-model="pay.account_pass" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="payDialog = false">取 消</el-button>
      <el-button type="primary" @click="submitSets()">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
import ImageConst from '@/components/constants/ImageConst'
import {mapMutations, mapGetters} from 'vuex'

export default {
  name: 'BuySet',
  data () {
    return {
      cinemaId: this.$route.params.item['cinema_id'],
      price: this.$route.params.item['movie_price'],
      item: this.$route.params.item,
      setIco: {
        padding: '5px 20px 5px 20px',
        background: `url("${ImageConst.setico}") no-repeat`
      },
      setChoseIco: {
        padding: '5px 20px 5px 20px',
        background: `url("${ImageConst.setChoseIco}") no-repeat`
      },
      setToChoseIco: {
        padding: '5px 20px 5px 20px',
        background: `url("${ImageConst.setToChoseIco}") no-repeat`
      },
      setArr: [],
      payDialog: false,
      pay: {},
      setsChoose: []
    }
  },
  computed: {
    totalMoney: function () {
      return this.price * this.setArr.length
    },
    ...mapGetters({
      userStore: 'getUser'
    })
  },
  created: function () {
    this.getSetChooseInfo()
  },
  methods: {
    ...mapMutations({
      storeUserInfo: 'initUserInformation'
    }),
    // 查询已选座位数据
    getSetChooseInfo: function () {
      const screenId = this.item['screen_id']
      this.axios.post('/sakura/ticket/orderSets', {
        screen_id: screenId
      }).then(response => {
        this.loading = false
        if (response['data'].code === 200) {
          const setsInfo = response['data']['data']
          setsInfo.forEach(value => this.setsChoose.push(value['row'] + '-' + value['clo']))
        } else {
          this.$message({
            message: '查询失败，请确认网络环境后重试',
            type: 'error'
          })
        }
      }).catch(exception => {
        this.loading = false
        this.$message({
          message: '查询失败，请确认网络环境后重试',
          type: 'error'
        })
      })
    },
    chooseThis (event, row, clo) {
      if (event.currentTarget.style.background === this.setIco.background) {
        if (this.setArr.length >= 4) {
          this.$message({
            message: '超出个人购票最大数量',
            type: 'error'
          })
          return
        }
        event.currentTarget.style.background = this.setToChoseIco.background
        this.setArr.push({
          row: row,
          clo: clo
        })
      } else {
        event.currentTarget.style.background = this.setIco.background
        this.setArr = this.setArr.filter((value, index, arr) => (value.row !== row || value.clo !== clo))
      }
    },
    showPayDialog: function () {
      this.payDialog = true
    },
    submitSets: function () {
      let userStr = localStorage.getItem('user')
      let user = JSON.parse(userStr)
      const paramArr = []
      this.setArr.forEach((value) => {
        paramArr.push({
          user_id: user['user_id'],
          user_account: this.pay.user_account,
          account_pass: this.pay.account_pass,
          row: value.row,
          clo: value.clo,
          screen_id: this.item['screen_id'],
          price: this.item['movie_price']
        })
      })
      this.axios.post('/sakura/ticket/orderTicket',
        paramArr
      ).then(response => {
        this.loading = false
        if (response['data'].code === 200) {
          this.payDialog = false
          this.$notify({
            title: '成功',
            dangerouslyUseHTMLString: true,
            message: '订票成功<br>' +
              '取票号:' + response['data']['data']['order_code'] + ' 验证码:' + response['data']['data']['order_pass'] +
              '<br>详细订单信息请到订单页面查看',
            type: 'success'
          })
          this.$router.push({
            path: '/'
          })
        } else {
          this.$message({
            message: response['data']['data']['message'],
            type: 'error'
          })
        }
        const updateUser = this.userStore
        updateUser.account_money = response['data']['data']['money']
        this.storeUserInfo(updateUser)
      }).catch(exception => {
        this.loading = false
        this.$message({
          message: '查询失败，请确认网络环境后重试',
          type: 'error'
        })
      })
    }
  }
}
</script>

<style scoped>
.set-content {
  text-align: left;
  margin-left: 3rem;
}
.cinema_info {
  border-left: solid red 5px;
  padding-left: 1rem;
  margin-bottom: 1rem;
}
.limit-width, .limit-width span {
  width: 20px;
}
.limit-width {
  margin-top: 60px;
  background-color: #8c939d;
}
.limit-width span {
  text-align: center;
  display: inline-block;
  margin: 15px 0 15px 0;
}
.screen-class {
  margin-left: 1.5rem;
}
.screen-location {
  height: 60px;
  width: 100%;
  text-align: center;
  background-color: #8c939d;
  color: white;
}
.screen-set {
  padding: 15px;
}
.tips {
  margin-top: 10px;
  margin-left: 5px;
  padding: 14px 33px!important;
}
.bottom-tips {
  margin: 1rem 3rem;
}
.bottom-tips span {
  line-height: 0;
}
.right-margin {
  margin-right: 5rem;
}
</style>
