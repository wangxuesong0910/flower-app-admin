<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->
		
		<view v-if="current === 0">
			<u-form :model="form" class="apply-form-field">
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="三级分类" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
<!-- 				<u-form-item label="档次" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->
				<u-form-item label="出库类型" label-width="45%" >
					<!-- <u-input placeholder="正常出库,损坏出库" type="select" class="form-field-select" /> -->
					<u-radio-group v-model="outStatusValue" >
								<u-radio 
									
									v-for="(item, index) in outStatusList" :key="index" 
									:name="item.name"
									:disabled="item.disabled"
								>
									{{item.name}}
								</u-radio>
							</u-radio-group>
				</u-form-item>
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="出库数量(扎)" label-width="70%">
					<u-number-box v-model="value" @change="valChange"></u-number-box>
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
	<view v-if="current === 1">
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
	</view>
</template>
<script>
	export default {
		data() {
			return {
				outStatusValue: 'apple',
				outStatusList: [
				{
					name: '正常出库',
					disabled: false
				},
				{
					name: '报损出库',
					disabled: false
				}
			],
				value: 0,
				show: false,
				list: [{
					name: '出库单'
				}, {
					name: '库存列表',
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
			outStatusOpen(){
				this.outStatusShow = true;
			},
			valChange(e) {
							console.log('当前值为: ' + e.value)
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
