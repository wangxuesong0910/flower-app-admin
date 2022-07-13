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
					<image class="user-images" src="/static/aidex/images/user06.png"></image>品种：{{item.type}}
				</view>
				<view style="color: #999999;font-size: 22rpx;">{{item.createTime}}</view>
			</view>
			<view class="" slot="body">
				<u-row gutter="16">
					<u-col span="12">
						<view class="apply-text"><span>品质：</span>{{item.grade}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>库存：</span>{{item.quantity}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>进货价：</span>{{item.buyingPrice}} 元</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>入库时间：</span>{{item.enterDatetime}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>出库时间：</span>{{item.takeoutDatetime}}</view>
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
		<view class="search">
			<u-search v-model="keyWords" @custom="search" @search="search"></u-search>
		</view>
			
		<u-card v-for="item in dataList" :key="item.age" class="task-list-item" :border="false" padding="20"
			margin="20rpx">
			<view slot="head" style="display: flex;align-items: center;justify-content: space-between;">
				<view style="display: flex;align-items: center;font-size: 30rpx;">
					<image class="user-images" src="/static/aidex/images/user06.png"></image>品种：{{item.type}}
				</view>
				<view style="color: #999999;font-size: 22rpx;">{{item.createTime}}</view>
			</view>
			<view class="" slot="body">
				<u-row gutter="16">
					<u-col span="12">
						<view class="apply-text"><span>品质：</span>{{item.grade}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>库存：</span>{{item.quantity}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>进货价：</span>{{item.buyingPrice}} 元</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>入库时间：</span>{{item.enterDatetime}}</view>
					</u-col>
					<u-col span="12">
						<view class="apply-text"><span>出库时间：</span>{{item.takeoutDatetime}}</view>
					</u-col>
				</u-row>
			</view>
			<view class="apply-list-foot" slot="foot" style="text-align: right;color: #58ca93;">
				<u-button type="primary" size="mini" shape="circle" :ripple="true">修改</u-button>
				<u-button type="error" size="mini" shape="circle" :ripple="true">删除</u-button>
			</view>
		</u-card>
	</view>
	
	</view>
</template>
<script>
	export default {
		data() {
			return {
				show: false,
				list: [{
					name: '库存列表'
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
				dataList: [],
				keyWords: '',
				form:{}
			}
		},
		onLoad() {
			
		},
		created(){
			this.getList();
		},
		methods: {
			// 查询列表
			getList(){
				this.$u.api.storageListData.listData({
			}).then(res => {
				this.dataList = res.rows;
			})
			},
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
