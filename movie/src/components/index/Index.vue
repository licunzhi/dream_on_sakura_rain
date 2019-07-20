<template>
  <el-container style="width: 100%; height: 100%;overflow: auto">
    <el-aside class="main_aside">
      <!--今日票房数据统计-->
      <div class="aside_top">
        <h3 class="top_font">今日票房</h3>

        <el-row :gutter="20" class="img_show">
          <el-col :span="6">
            <img :src="portraitPic" alt="影片介绍">
          </el-col>
          <el-col :span="18">
            <div class="word_break_line">
              This is a new page about information
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20" class="img_show">
          <el-col :span="6">
            <img :src="portraitPic" alt="影片介绍">
          </el-col>
          <el-col :span="18">
            <div class="word_break_line">
              This is a new page about information
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20" class="img_show">
          <el-col :span="6">
            <img :src="portraitPic" alt="影片介绍">
          </el-col>
          <el-col :span="18">
            <div class="word_break_line">
              This is a new page about information
            </div>
          </el-col>
        </el-row>
      </div>

      <!--今日数据汇总-->
      <div class="today_data">
        <h3>今日大盘</h3>
        <div>
          <p class="today_data_num">
            <span>180.35</span>
            万
            <a href="#">查看更多<i class="el-icon-arrow-right"></i></a>
          </p>
          <p class="data_num_info">
            北京时间 09:15:58
            <span>Sakura专业版实时票房数据</span>
          </p>
        </div>
      </div>

      <!--最受期待-->
      <div class="most-expect-wrapper">
        <!--header-->
        <div>
          <span class="right_float"><a href="#">查看完成榜单<i class="el-icon-arrow-right"></i></a></span>
          <span>
          <h3>最受期待</h3>
        </span>
        </div>
      </div>
      <!--body-->
      <div class="most-expect-list">

        <el-row>
          <el-col :span="8">
            <img class="big" :src="portraitPic" alt="影片介绍">
          </el-col>
          <el-col :span="16">
            <div class="word_break_line">
              This is a new page about information
            </div>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-row>
              <el-col :span="10">
                <img class="small" :src="portraitPic" alt="影片介绍">
              </el-col>
              <el-col :span="14">
                <div class="word_break_line">
                  This is a new page about information
                </div>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-row>
              <el-col :span="10">
                <img class="small" :src="portraitPic" alt="影片介绍">
              </el-col>
              <el-col :span="14">
                <div class="word_break_line">
                  This is a new page about information
                </div>
              </el-col>
            </el-row>
          </el-col>
        </el-row>

        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
      </div>

      <!--Top10-->
      <div class="top_wrapper">
        <!--header-->
        <div>
          <span class="right_float"><a href="#">查看完整榜单<i class="el-icon-arrow-right"></i></a></span>
          <span>
            <h3>TOP100</h3>
          </span>
        </div>
      </div>

      <div class="most-expect-list">
        <el-row>
          <el-col :span="8">
            <img class="big" :src="portraitPic" alt="影片介绍">
          </el-col>
          <el-col :span="12">
            <div class="word_break_line">
              111111111111111111111111111111111111111111111111111111111111
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
        <el-row :gutter="24">
          <el-col :span="12"><span>4</span>小小的愿望</el-col>
          <el-col :offset="4" :span="8" style="text-align: right">123128人想看</el-col>
        </el-row>
      </div>
    </el-aside>
    <!--中间部分-->
    <el-main style="margin: 0 3rem 0 3rem;overflow: visible;" class="center-main">
      <!--正在热映-->
      <!--header-->
      <div class="hot_header">
        <span class="right_float"><a href="#">全部<i class="el-icon-arrow-right"></i></a></span>
        <span style="text-align: left">
          <h3>正在热映(<span>49</span>部)</h3>
        </span>
      </div>
      <!--body-->
      <div class="hot_body">
        <!--card-->
        <el-row>
          <el-col :span="6" v-for="(o, index) in 3" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card shadow="hover" :body-style="{ padding: '0px' }">
              <img :src="portraitPic"
                   class="image">
              <div style="padding: 14px;">
                <span>好看的电影</span>
                <div class="bottom clearfix">
                  <time class="time">2019-07-03</time>
                  <el-button type="text" class="button">购买</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6" v-for="(o, index) in 3" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card shadow="hover" :body-style="{ padding: '0px' }">
              <img :src="portraitPic"
                   class="image">
              <div style="padding: 14px;">
                <span>好看的电影</span>
                <div class="bottom clearfix">
                  <time class="time">2019-07-03</time>
                  <el-button type="text" class="button">购买</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>

      <!--即将上映-->
      <!--header-->
      <div class="coming_header">
        <span class="right_float"><a href="#">全部<i class="el-icon-arrow-right"></i></a></span>
        <span style="text-align: left">
          <h3>即将上映(<span>169</span>部)</h3>
        </span>
      </div>

      <div class="coming_body">
        <!--card-->
        <el-row>
          <el-col :span="6" v-for="(o, index) in 3" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card :body-style="{ padding: '0px' }">
              <img :src="portraitPic"
                   class="image">
              <div style="padding: 14px;">
                <span>好看的电影</span>
                <div class="bottom clearfix">
                  <time class="time">2019-07-03</time>
                  <el-button type="text" class="button">预售</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="6" v-for="(o, index) in 3" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card :body-style="{ padding: '0px' }">
              <img :src="portraitPic"
                   class="image">
              <div style="padding: 14px;">
                <span>好看的电影</span>
                <div class="bottom clearfix">
                  <time class="time">2019-07-03</time>
                  <el-button type="text" class="button">预售</el-button>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </el-main>
  </el-container>
</template>

<script>
import ImageConst from '@/components/constants/ImageConst'

export default {
  name: 'Index',
  data () {
    return {
      portraitPic: ImageConst.moviePic
    }
  }
}
</script>

<style scoped>
.left_float {
  float: left;
}
.right_float {
  float: right;
}
/*inner aside*/
.main_aside {
  width: 25%!important;
  text-align: left;
  overflow: visible
}
.aside_top  {
  margin-left: 1rem;
  overflow-x: hidden;
}
.top_font {
  color: #ef4238;
}
.aside_top img {
  width: 3rem;
  height: 2rem;
}
.aside_top .el-row {
  background-color: #efefef;
  cursor: pointer;
}
/*toady data style*/
.today_data {
  margin: 2rem 0 0 1rem;
  width: 90%;
  height: 4rem;
  border: #545c64 1px dashed;
}
.today_data h3 {
  width: 0.7rem;
  background-color: #ef4238;
  color: #fff;
  margin: 0px;
  line-height: 1rem;
  float: left;
}
.today_data_num {
  color: #ef4238;
  margin-left: 1rem;
  margin-top: 1rem;
}
.today_data_num span {
  font-size: 0.8rem;
  font-weight: bold;
  text-align: center;
}
.today_data_num a {
  text-decoration: none;
  color: #ef4238;
  float: right;
  margin-right: 1rem;
}
.data_num_info {
  margin-left: 1rem;
  margin-top: 1rem;
  color: #999;
}
.data_num_info span {
  float: right;
  margin-right: 1rem;
}
/*most except style*/
.most-expect-wrapper,.most-expect-list,.top_wrapper {
  margin: 1rem 0 0 1rem;
}
.most-expect-list img.big {
  width: 120px;
  height: 100px
}
.most-expect-list img.small {
  width: 80px;
  height: 65px
}
.most-expect-list .el-row {
  background-color: #efefef;
  cursor: pointer;
  margin-left: 0!important;
  margin-right: 0!important;
}
/*文字断行*/
.word_break_line {
  word-break: break-all;
  word-wrap: break-word;
}
.el-row {
  margin-bottom: 20px;
}
.most-expect-wrapper div span a,
.most-expect-wrapper div span h3,
.top_wrapper div span a,
.top_wrapper div span h3{
  text-decoration: none;
  color: #ffb400;
}
/*cent main style*/
.center-main .hot_header span a,
.center-main .hot_header span h3 {
  text-decoration: none;
  color: #ef4238;
}
/*即将上映的*/
.center-main .coming_header span a,
.center-main .coming_header  span h3 {
  text-decoration: none;
  color: #2d98f3;
}
</style>
