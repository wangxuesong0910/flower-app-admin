<template>
	<view class="wrap">
		<head-nav-bar title="首页" />
		<u-swiper :height="270" :list="imgList" :title="false" @click="imgListClick"></u-swiper>
		<view class="dashboard-editor-container">
			<u-row gutter="16">
				<u-col span="3">
					<uni-view class="u-demo-wrap">
						<u-row gutter="1">
							<u-col span="6">
								<!-- <uni-view class="u-demo-title">演示效果</uni-view> -->
								<uni-view id="u-tab-item-1" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; margin-left: -10px;">
									<iconFont name="peoples" color="#40c9c6"></iconFont>
								</uni-view>
							</u-col>
							<u-col span="6">
								<uni-view id="u-tab-item-2" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 5rpx; color: rgba(0, 0, 0, 0.45);">
									<!---->用户
								</uni-view>
								<uni-view class="u-tab-item u-line-1" style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 10rpx;font-weight: bold;">{{todoCount}}</uni-view>
							</u-col>
						</u-row>
					</uni-view>
				</u-col>
				<u-col span="3">
					<uni-view class="u-demo-wrap">
						<u-row gutter="1">
							<u-col span="6">
								<!-- <uni-view class="u-demo-title">演示效果</uni-view> -->
								<uni-view id="u-tab-item-1" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; margin-left: -10px;">
									<iconFont name="message" color="#36a3f7"></iconFont>
								</uni-view>
							</u-col>
							<u-col span="6">
								<uni-view id="u-tab-item-2" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 5rpx; color: rgba(0, 0, 0, 0.45);">
									<!---->库存
								</uni-view>
								<uni-view class="u-tab-item u-line-1" style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 10rpx;font-weight: bold;">{{todoCount}}</uni-view>
							</u-col>
						</u-row>


					</uni-view>
				</u-col>
				<u-col span="3">
					<uni-view class="u-demo-wrap">
						<u-row gutter="1">
							<u-col span="6">
								<!-- <uni-view class="u-demo-title">演示效果</uni-view> -->
								<uni-view id="u-tab-item-1" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; margin-left: -10px;">
									<iconFont name="message" color="#f4516c"></iconFont>
								</uni-view>
							</u-col>
							<u-col span="6">
								<uni-view id="u-tab-item-2" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 5rpx; color: rgba(0, 0, 0, 0.45);">
									<!---->损坏
								</uni-view>
								<uni-view class="u-tab-item u-line-1" style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 10rpx;font-weight: bold;">{{todoCount}}</uni-view>
							</u-col>
						</u-row>


					</uni-view>
				</u-col>
				<u-col span="3">
					<uni-view class="u-demo-wrap">
						<u-row gutter="1">
							<u-col span="6">
								<!-- <uni-view class="u-demo-title">演示效果</uni-view> -->
								<uni-view id="u-tab-item-1" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; margin-left: -10px;">
									<iconFont name="money" color="#34bfa3"></iconFont>
								</uni-view>
							</u-col>
							<u-col span="6">
								<uni-view id="u-tab-item-2" class="u-tab-item u-line-1"
									style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 5rpx; color: rgba(0, 0, 0, 0.45);">
									<!---->订单
								</uni-view>
								<uni-view class="u-tab-item u-line-1" style=" transition-duration: 0.5s; font-size: 15px; padding-left: 10rpx;margin-top: 10rpx;font-weight: bold;">{{todoCount}}</uni-view>
							</u-col>
						</u-row>

					</uni-view>
				</u-col>
			</u-row>
		</view>
<view class="charts-box">
    <qiun-data-charts 
      type="pie"
      :opts="opts"
      :chartData="chartData"
    />
  </view>
		<u-divider>已经到底了</u-divider>
	</view>

</template>
<script>
	import HeadNavBar from '@/components/headnavbar/index';
	import iconFont from '@/components/iconfont/index';
	/**
	 * Copyright (c) 2013-Now http://aidex.vip All rights reserved.
	 */
	export default {
		components: {
			HeadNavBar,
			iconFont
		},
		data() {
			return {
				chartData: {},
				      //您可以通过修改 config-ucharts.js 文件中下标为 ['pie'] 的节点来配置全局默认参数，如都是默认参数，此处可以不传 opts 。实际应用过程中 opts 只需传入与全局默认参数中不一致的【某一个属性】即可实现同类型的图表显示不同的样式，达到页面简洁的需求。
				      opts: {
				        color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
				        padding: [5,5,5,5],
				        extra: {
				          pie: {
				            activeOpacity: 0.5,
				            activeRadius: 10,
				            offsetAngle: 0,
				            labelWidth: 15,
				            border: false,
				            borderWidth: 3,
				            borderColor: "#FFFFFF"
				          }
				        }
				      },
				show: false,
				head: '/static/aidex/images/head.png',
				imgList: [
					// {image: '/static/aidex/banner/banner01.png'},
					// {image: '/static/aidex/banner/banner02.png'}, 
					// {image: '/static/aidex/banner/banner03.png'},
					{
						image: '/static/aidex/banner/flower01.jpg'
					},
					{
						image: '/static/aidex/banner/flower02.jpg'
					},
					{
						image: '/static/aidex/banner/flower03.jpg'
					},
					{
						image: '/static/aidex/banner/flower04.jpg'
					},
				],
				todoCount: 3
			};
		},
		onLoad() {

		},
		onReady() {
			this.getServerData();
		},
		methods: {
			getServerData() {
			      //模拟从服务器获取数据时的延时
			      setTimeout(() => {
			        //模拟服务器返回数据，如果数据格式和标准格式不同，需自行按下面的格式拼接
			        let res = {
			            series: [
			              {
			                data: [{"name":"一班","value":50},{"name":"二班","value":30},{"name":"三班","value":20},{"name":"四班","value":18},{"name":"五班","value":8}]
			              }
			            ]
			          };
			        this.chartData = JSON.parse(JSON.stringify(res));
			      }, 500);
			    },
			navTo(url) {
				uni.navigateTo({
					url: url
				});
			},
			imgListClick(index) {
				console.log(`点击了第${index + 1}页图片`)
			},
			itemClick(index) {
				console.log(index);
			}
		}
	};
</script>
<style lang="scss">
	@import 'index.scss';
/* 请根据实际需求修改父元素尺寸，组件自动识别宽高 */
  .charts-box {
    width: 100%;
    height: 300px;
  }
	.u-demo-wrap {
		border-width: 1px;
		border-color: #ddd;
		border-style: dashed;
		background-color: #fafafa;
		padding: 5px 5px;
		border-radius: 7px;
		height: 80px;
	}

	.dashboard-editor-container {
		padding: 20px;
		background-color: rgb(240, 242, 245);

		.chart-wrapper {
			background: #fff;
			padding: 10px 10px 0;
			margin-bottom: 30px;
		}
	}


	.banner-box {
		padding: 0 2%;
		width: 96%;
		height: 170rpx;
		margin: 30rpx 0 30rpx;
	}

	.u-swiper-wrap {
		padding: 0 10px;
	}

	.banner-pic {
		width: 47%;
		float: left;
		display: inline-block;
		margin: 0 1.5%;
	}

	.banner-pic image {
		width: 100%;
		height: 170rpx;
		border-radius: 12rpx;
		box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
	}

	.u-mode-light-info {
		background-color: #ffffff;
		color: #666666;
		border: 1px solid #e9ecf6;
		font-size: 12px;
		padding: 2px 8px;
		position: relative;
		top: -3px;
	}
</style>
