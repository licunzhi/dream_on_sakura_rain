<template>
    <div style="width: 100%; height: 100%; overflow: auto">
      <div class="movie_list" v-loading="loading" element-loading-text="玩命加载中...">
          <el-row>
            <div class="movie_item" v-for="(item, index) in moviesList" :key="index">
                <el-col :span="4" :offset="1" style="margin-bottom: 2rem">
                  <el-card shadow="hover" :body-style="{ padding: '0px' }">
                    <img :src="item.movie_pic ? item.movie_pic : defaultPic"
                         style="height: 8rem; width: 6rem; border:none; padding: 10px">
                    <div style="padding: 14px;">
                      <span>{{item.movie_name}}</span>
                      <div class="bottom clearfix">
                        <time class="time">{{item.released_time}}</time>
                        <el-button type="danger" size='small' round @click="toMTicket(item)">购买</el-button>
                      </div>
                    </div>
                  </el-card>
                </el-col>
            </div>
          </el-row>
      </div>

      <div class="pagination">
        <el-pagination
          :background="true"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :current-page.sync="pageNum"
          :total="total">
        </el-pagination>
      </div>
    </div>
</template>

<script>
import ImageConst from '@/components/constants/ImageConst'

export default {
  name: 'MovieList',
  data () {
    return {
      conditions: {
        kind: '',
        period: '',
        region: ''
      },
      total: 0,
      pageSize: 12,
      pageNum: 1,
      moviesList: [],
      loading: false,
      defaultPic: ImageConst.moviePic
    }
  },
  filters: {
  },
  mounted () {
    this.searchMovies()
  },
  watch: {
    searConditionsFirst: {
      handler (newVal, oldVal) {
        if (newVal['activeName'] === 'first') {
          this.conditions = newVal
          this.searchMovies()
        }
      }
    },
    searConditionsSecond: {
      handler (newVal, oldVal) {
        if (newVal['activeName'] === 'second') {
          this.conditions = newVal
          this.searchMovies()
        }
      }
    },
    searConditionsThird: {
      handler (newVal, oldVal) {
        if (newVal['activeName'] === 'third') {
          this.conditions = newVal
          this.searchMovies()
        }
      }
    }
  },
  // 父组件传递过来的参数
  props: ['searConditionsFirst', 'searConditionsSecond', 'searConditionsThird'],
  methods: {
    handleCurrentChange (val) {
      this.searchMovies()
    },
    searchMovies () {
      this.loading = true
      this.axios.post('/sakura/Movie/search', {
        kind: `[${this.conditions.kind}]`,
        period: `[${this.conditions.period}]`,
        region: `[${this.conditions.region}]`,
        pageSize: this.pageSize,
        pageNum: this.pageNum
      }).then(response => {
        this.loading = false
        if (response['data'].code === 200) {
          const movies = response['data']['data']
          this.moviesList = movies['list']
          this.total = movies['total']
        } else {
          this.$message({
            message: '查询失败，请确认网络环境后重试',
            type: 'error'
          })
        }
        this.loading = false
      }).catch(exception => {
        this.loading = false
        this.$message({
          message: '查询失败，请确认网络环境后重试',
          type: 'error'
        })
        this.loading = false
      })
    },
    toMTicket (item) {
      let userStr = localStorage.getItem('user')
      let user = JSON.parse(userStr)
      if (user == null) {
        this.$message({
          message: '请登录后，重新点击购买...',
          type: 'error'
        })
        return
      }
      this.$router.push({
        name: 'MovieTicket',
        params: {movie: item}
      })
    }
  }
}
</script>

<style scoped>

</style>
