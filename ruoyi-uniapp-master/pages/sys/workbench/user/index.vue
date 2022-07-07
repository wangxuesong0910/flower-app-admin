<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->
		<view v-if="current === 0">
			<view class="search">
				<u-search v-model="keyWords" @custom="search" @search="search"></u-search>
			</view>

			<u-card v-for="item in dataList" :key="item.age" class="task-list-item" :border="false" padding="20"
				margin="20rpx">
				<view slot="head" style="display: flex;align-items: center;justify-content: space-between;">
					<view style="display: flex;align-items: center;font-size: 30rpx;">
						<image class="user-images" src="/static/aidex/images/user06.png"></image>用户：{{item.name}}
					</view>
					<view style="color: #999999;font-size: 22rpx;">2021年10月24日</view>
				</view>
				<view class="" slot="body">
					<u-row gutter="16">
						<u-col span="12">
							<view class="apply-text"><span>假期天：</span>{{item.age}}</view>
						</u-col>
						<u-col span="12">
							<view class="apply-text"><span>开始时间：</span>2021年10月25日14:30</view>
						</u-col>
						<u-col span="12">
							<view class="apply-text"><span>结束时间：</span>2021年10月27日14:30</view>
						</u-col>
					</u-row>
				</view>
				<view class="apply-list-foot" slot="foot" style="text-align: right;color: #58ca93;">
					<u-button type="primary" size="mini" shape="circle" :ripple="true">修改</u-button>
					<u-button type="error" size="mini" shape="circle" :ripple="true">删除</u-button>
				</view>
			</u-card>

		</view>
		<view v-if="current === 1">
			<u-form :model="form" class="apply-form-field">
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="请假类型" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="开始时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-form-item label="结束时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="请假事由" label-width="150"></u-form-item>
				<u-form-item>
					<u-input type="textarea" placeholder="请输入内容" />
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="图片" label-width="150">
					<view solt="right" style="flex:1;text-align: right;align-items: center;">
						<i class="add-user iconfont icon-tupian"></i>
					</view>
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="选人处理人" label-width="150">
					<view solt="right" style="flex:1;text-align: right;align-items: center;">
						<i class="add-user iconfont icon-zengjia"></i>
					</view>
				</u-form-item>
				<u-form-item>
					<view class="personnel-list">
						<view class="personnel-user">
							<image class="user-images" src="/static/aidex/images/user01.png"></image>
							<i class="iconfont icon-close-circle-fill"></i>
						</view>
						<view class="personnel-user">
							<image class="user-images" src="/static/aidex/images/user02.png"></image>
							<i class="iconfont icon-close-circle-fill"></i>
						</view>
						<view class="personnel-user">
							<image class="user-images" src="/static/aidex/images/user03.png"></image>
							<i class="iconfont icon-close-circle-fill"></i>
						</view>
						<view class="personnel-user">
							<image class="user-images" src="/static/aidex/images/user04.png"></image>
							<i class="iconfont icon-close-circle-fill"></i>
						</view>
						<view class="personnel-user">
							<image class="user-images" src="/static/aidex/images/user05.png"></image>
							<i class="iconfont icon-close-circle-fill"></i>
						</view>
					</view>
				</u-form-item>
			</u-form>
			<u-row gutter="32" class="bottom-box" justify="center">
				<u-col span="10">
					<view>
						<u-button type="primary" shape="circle" @click="navTo('/pages/sys/home/index')">确定</u-button>
					</view>
				</u-col>
			</u-row>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				show: false,
				list: [{
					name: '用户列表'
				}, {
					name: '添加用户',
				}],
				m2mSimflowList: [],
				m2mOrderFlowList: [],
				current: 0,
				status: 'loadmore',
				iconType: 'circle',
				isDot: false,
				loadText: {
					loadmore: '点击加载更多',
					loading: '正在加载...',
					nomore: '没有更多了'
				},
				dataList: [{
					age: 1,
					name: 'aaa'
				}, {
					age: 2,
					name: 'bbb'
				}, {
					age: 3,
					name: 'ccc'
				}],
				keyWords: '',
				form:{}
			}
		},
		created() {},
		methods: {
			change(index) {
				this.current = index;
			},
			navTo(url) {
				uni.navigateTo({
					url: url
				});
			}
		}

	}
</script>
<style lang="scss" scoped>
	@import '../index.scss';

	page {
		background-color: #f5f5f5;
	}

	.wrap .search {
		background: #ffffff;
	}

	.apply-text {
		font-size: 28rpx;
		color: #333333;

		span {
			color: #999999;
		}
	}

	.user-images {
		width: 28px;
		height: 28px;
		margin-right: 8px;
	}

	.apply-list-foot {
		font-size: 28rpx;
	}

	.personnel-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;

		.personnel-user {
			position: relative;
			margin: 5px 9px 0;
		}

		.user-images {
			width: 48px;
			height: 48px;
			margin-right: 0;

		}

		.iconfont {
			position: absolute;
			top: -12px;
			right: -5px;
			color: #FE0100;
		}
	}
</style>
