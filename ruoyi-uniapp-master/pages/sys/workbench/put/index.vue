<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->

		<view v-if="current === 0">
			<u-form :model="form" class="apply-form-field">
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
<!-- 				<u-form-item label="一级分类" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->

				<u-form-item label="三级分类" label-width="130">
					<u-input v-model="detailSelectValue" type="select" @click="detailSelectListOpen" />
					<u-action-sheet :list="appDetailSelectList" v-model="appDetailSelectListShow"
						@click="detailSelectCallback1"></u-action-sheet>
					<!-- <u-input placeholder="请选择一级分类" v-model="list.name" type="select" class="form-field-select" /> -->
				</u-form-item>
				<!-- <u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="开始时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-form-item label="结束时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->
				<u-form-item label="数量" label-width="150" >
					<u-input placeholder="请输入" type="input" />
				</u-form-item>
<!-- 				<u-form-item label="批发方式" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->
				<u-form-item label="进货价" label-width="150" >
					<u-input placeholder="请输入" type="input" />
				</u-form-item>
				<u-form-item label="档次:" label-width="130">
					<u-input v-model="value" type="select" @click="gradeListOpen" />
					<u-action-sheet :list="gradeList" v-model="gradeListShow"
						@click="gradeSelectCallback1"></u-action-sheet>
					<!-- <u-input placeholder="请选择一级分类" v-model="list.name" type="select" class="form-field-select" /> -->
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
				value: '',
				detailSelectValue: '',
				gradeListShow: false,
				appDetailSelectListShow: false,
				show: false,
				list: [{
					name: '批发入库'
				}],
				//档次
				gradeList:[{
					text: 'A'
				},{
					text: 'B'
				}],
				//三级分类下拉列表
				appDetailSelectList:[],
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
		onLoad() {
			this.getAppDetailSelect();
		},
		created() {},
		methods: {
			getAppDetailSelect(){
				this.$u.api.put.appDetailSelectList({
				}).then(res => {
					this.appDetailSelectList = res.rows;
				})
			},
			// 点击actionSheet回调
			gradeSelectCallback1(index) {
				this.value = this.gradeList[index].text;
			},
			// 点击actionSheet回调
			detailSelectCallback1(index) {
				this.detailSelectValue = this.appDetailSelectList[index].text;
			},
			gradeListOpen(){
				this.gradeListShow = true;
			},
			detailSelectListOpen(){
				this.appDetailSelectListShow = true;
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
