<template>
  <div class="movie-content" style="width: 100%;height: 100%; overflow: auto">
      <!--顶部筛选-->
      <div class="top_wait_choose">
        <!--种类-->
        <div class="content clearfix">
          <div class="brand">类型:</div>
          <ul class="brand-ul">
            <li><a href="#" :class="kind === '' ? 'active' : ''" @click="changeActive('')" >全部</a></li>
            <li><a href="#" :class="kind === 1 ? 'active' : ''" @click="changeActive(1)">爱情</a></li>
            <li><a href="#" :class="kind === 2 ? 'active' : ''" @click="changeActive(2)">喜剧</a></li>
            <li><a href="#" :class="kind === 3 ? 'active' : ''" @click="changeActive(3)">动画</a></li>
            <li><a href="#" :class="kind === 4 ? 'active' : ''" @click="changeActive(4)">剧情</a></li>
            <li><a href="#" :class="kind === 5 ? 'active' : ''" @click="changeActive(5)">恐怖</a></li>
            <li><a href="#" :class="kind === 6 ? 'active' : ''" @click="changeActive(6)">惊悚</a></li>
            <li><a href="#" :class="kind === 7 ? 'active' : ''" @click="changeActive(7)">科幻</a></li>
            <li><a href="#" :class="kind === 8 ? 'active' : ''" @click="changeActive(8)">动作</a></li>
            <li><a href="#" :class="kind === 9 ? 'active' : ''" @click="changeActive(9)">悬疑</a></li>
            <li><a href="#" :class="kind === 10 ? 'active' : ''" @click="changeActive(10)">犯罪</a></li>
            <li><a href="#" :class="kind === 11 ? 'active' : ''" @click="changeActive(11)">冒险</a></li>
            <li><a href="#" :class="kind === 12 ? 'active' : ''" @click="changeActive(12)">战争</a></li>
            <li><a href="#" :class="kind === 13 ? 'active' : ''" @click="changeActive(13)">奇幻</a></li>
            <li><a href="#" :class="kind === 14 ? 'active' : ''" @click="changeActive(14)">运动</a></li>
            <li><a href="#" :class="kind === 15 ? 'active' : ''" @click="changeActive(15)">家庭</a></li>
            <li><a href="#" :class="kind === 16 ? 'active' : ''" @click="changeActive(16)">武装</a></li>
            <li><a href="#" :class="kind === 17 ? 'active' : ''" @click="changeActive(17)">西部</a></li>
            <li><a href="#" :class="kind === 18 ? 'active' : ''" @click="changeActive(18)">历史</a></li>
            <li><a href="#" :class="kind === 19 ? 'active' : ''" @click="changeActive(19)">传记</a></li>
            <li><a href="#" :class="kind === 20 ? 'active' : ''" @click="changeActive(20)">歌舞</a></li>
            <li><a href="#" :class="kind === 21 ? 'active' : ''" @click="changeActive(21)">黑色电影</a></li>
            <li><a href="#" :class="kind === 22 ? 'active' : ''" @click="changeActive(22)">短片</a></li>
            <li><a href="#" :class="kind === 23 ? 'active' : ''" @click="changeActive(23)">记录片</a></li>
            <li><a href="#" :class="kind === 24 ? 'active' : ''" @click="changeActive(24)">其他</a></li>
          </ul>
        </div>
        <!--区域-->
        <div class="content clearfix">
          <div class="region">区域:</div>
          <ul class="region-ul">
            <li><a href="#" :class="region === '' ? 'active' : ''" @click="changeSpActive('')">全部</a></li>
            <li><a href="#" :class="region === 1 ? 'active' : ''" @click="changeSpActive(1)">大陆</a></li>
            <li><a href="#" :class="region === 2 ? 'active' : ''" @click="changeSpActive(2)">美国</a></li>
            <li><a href="#" :class="region === 3 ? 'active' : ''" @click="changeSpActive(3)">韩国</a></li>
            <li><a href="#" :class="region === 4 ? 'active' : ''" @click="changeSpActive(4)">日本</a></li>
            <li><a href="#" :class="region === 5 ? 'active' : ''" @click="changeSpActive(5)">中国香港</a></li>
            <li><a href="#" :class="region === 6 ? 'active' : ''" @click="changeSpActive(6)">中国台湾</a></li>
            <li><a href="#" :class="region === 7 ? 'active' : ''" @click="changeSpActive(7)">泰国</a></li>
            <li><a href="#" :class="region === 8 ? 'active' : ''" @click="changeSpActive(8)">印度</a></li>
            <li><a href="#" :class="region === 9 ? 'active' : ''" @click="changeSpActive(9)">法国</a></li>
            <li><a href="#" :class="region === 10 ? 'active' : ''" @click="changeSpActive(10)">英国</a></li>
            <li><a href="#" :class="region === 11 ? 'active' : ''" @click="changeSpActive(11)">俄罗斯</a></li>
            <li><a href="#" :class="region === 12 ? 'active' : ''" @click="changeSpActive(12)">意大利</a></li>
            <li><a href="#" :class="region === 13 ? 'active' : ''" @click="changeSpActive(13)">西班牙</a></li>
            <li><a href="#" :class="region === 14 ? 'active' : ''" @click="changeSpActive(14)">德国</a></li>
            <li><a href="#" :class="region === 15 ? 'active' : ''" @click="changeSpActive(15)">波兰</a></li>
            <li><a href="#" :class="region === 16 ? 'active' : ''" @click="changeSpActive(16)">澳大利亚</a></li>
            <li><a href="#" :class="region === 17 ? 'active' : ''" @click="changeSpActive(17)">伊朗</a></li>
            <li><a href="#" :class="region === 18 ? 'active' : ''" @click="changeSpActive(18)">其他</a></li>
          </ul>
        </div>
        <!--年代-->
        <div class="content clearfix">
          <div class="region">年代:</div>
          <ul class="region-ul">
            <li><a href="#" :class="period === '' ? 'active' : ''" @click="changePeriod('')">全部</a></li>
            <li><a href="#" :class="period === 1 ? 'active' : ''" @click="changePeriod(1)">2019年以后</a></li>
            <li><a href="#" :class="period === 2 ? 'active' : ''" @click="changePeriod(2)">2019</a></li>
            <li><a href="#" :class="period === 3 ? 'active' : ''" @click="changePeriod(3)">2018</a></li>
            <li><a href="#" :class="period === 4 ? 'active' : ''" @click="changePeriod(4)">2017</a></li>
            <li><a href="#" :class="period === 5 ? 'active' : ''" @click="changePeriod(5)">2016</a></li>
            <li><a href="#" :class="period === 6 ? 'active' : ''" @click="changePeriod(6)">2015</a></li>
            <li><a href="#" :class="period === 7 ? 'active   ' : ''" @click="changePeriod(7)">2014</a></li>
            <li><a href="#" :class="period === 8 ? 'active' : ''" @click="changePeriod(8)">2013</a></li>
            <li><a href="#" :class="period === 9 ? 'active' : ''" @click="changePeriod(9)">2012</a></li>
            <li><a href="#" :class="period === 10 ? 'active' : ''" @click="changePeriod(10)">2011</a></li>
            <li><a href="#" :class="period === 11 ? 'active' : ''" @click="changePeriod(11)">2000-2010</a></li>
            <li><a href="#" :class="period === 12 ? 'active' : ''" @click="changePeriod(12)">90年代</a></li>
            <li><a href="#" :class="period === 13 ? 'active' : ''" @click="changePeriod(13)">80年代</a></li>
            <li><a href="#" :class="period === 14 ? 'active' : ''" @click="changePeriod(14)">70年代</a></li>
            <li><a href="#" :class="period === 15 ? 'active' : ''" @click="changePeriod(15)">更早</a></li>
          </ul>
        </div>

        <div class="sort-type clearfix">
          <el-radio v-model="sortType" label="1">按热门顺序</el-radio>
          <el-radio v-model="sortType" label="2">按时间顺序</el-radio>
          <el-radio v-model="sortType" label="3">按评价顺序</el-radio>
        </div>
      </div>
    <el-tabs v-model="activeName" :tab-position="tabPosition">
      <el-tab-pane label="正在热播" name="first"><MovieList :searConditionsFirst="{kind, region, period, activeName}"></MovieList></el-tab-pane>
      <el-tab-pane label="即将上映" name="second"><MovieList :searConditionsSecond="{kind, region, period, activeName}"></MovieList></el-tab-pane>
      <el-tab-pane label="经典电影" name="third"><MovieList :searConditionsThird="{kind, region, period, activeName}"></MovieList></el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import MovieList from './MovieList'

export default {
  name: 'Movies',
  components: {
    MovieList
  },
  data () {
    return {
      movie: 'sakura_rain',
      tabPosition: 'left',
      activeName: 'first',
      kind: '',
      region: '',
      period: '',
      sortType: '1'
    }
  },
  methods: {
    changeActive (code) {
      this.kind = code
    },
    changeSpActive (code) {
      this.region = code
    },
    changePeriod (code) {
      this.period = code
    }
  }
}
</script>

<style scoped>
.content {
  border-bottom: 1px dashed #e5e5e5;
  margin: 30px 30px 30px 30px;
}
.content:last-child {
  border-bottom: none;
  margin: 30px 30px 0 30px;
}
.brand,.region {
  float: left;
  width: 56px;
  color: #999;
}
.brand-ul,.region-ul {
  list-style: none;
}
.brand-ul li,.region-ul li {
  float: left;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
}
.brand-ul li a,.region-ul li a {
  text-decoration: none;
  color: #333;
  font-size: 14px;
  padding: 10px;
}
.brand-ul li a:hover,.region-ul li a:hover {
  text-decoration: none;
  color: #f34d41;
  font-size: 14px;
}
.brand-ul li a.active:hover,.region-ul li a.active:hover {
  text-decoration: none;
  color: #e5e5e5;
  font-size: 14px;
}
.active {
  color: #e5e5e5!important;
  background-color: #f34d41;
  border-radius: 20px;
}
.top_wait_choose{
  margin-bottom: 20px;
}
.sort-type {
}
</style>
