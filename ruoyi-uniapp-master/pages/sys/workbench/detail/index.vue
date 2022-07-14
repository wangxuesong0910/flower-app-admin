<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->

		<view v-if="current === 0">
			<!-- 添加一级分类 -->
			<u-modal v-model="leftShow" width="80%" title="科属添加" confirm-text="添加" :show-cancel-button="modalClose"
				@confirm="submitLeftForm">
				<u-form :model="leftForm" ref="leftForm">
					<u-form-item label="一级分类:" label-width="130">
						<u-input v-model="leftForm.ascription" placeholder="请输入科属" width="200" type="input" />
					</u-form-item>
				</u-form>
			</u-modal>
			<!-- 添加二级分类 -->
			<u-modal v-model="rightShow" width="80%" title="分类添加" confirm-text="添加" :show-cancel-button="modalClose"
				@confirm="submitRightForm">
				<u-form :model="rightForm" ref="rightForm">
					<u-form-item label="一级分类:" label-width="130">
						<u-input v-model="value" type="select" @click="rightFormSelectOpen1" />
						<u-action-sheet :list="rightFormSelectList" v-model="rightFormShow1"
							@click="rightFormSelectCallback1"></u-action-sheet>
						<!-- <u-input placeholder="请选择一级分类" v-model="list.name" type="select" class="form-field-select" /> -->
					</u-form-item>
					<u-form-item label="二级分类:" label-width="130">
						<u-input placeholder="请输入二级分类" width="200" type="input" v-model="rightForm.varieties" />
					</u-form-item>
				</u-form>
			</u-modal>
			<!-- 添加三级分类 -->
			<u-modal v-model="centerShow" width="80%" title="分类添加" confirm-text="添加" :show-cancel-button="modalClose"
				@confirm="submitCenterForm">
				<u-form :model="centerForm" ref="centerForm" class="apply-form-field">
					<u-gap height="20" bg-color="#f5f5f5"></u-gap>
					<!-- <u-form-item label="一级分类" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item> -->
				
					<u-form-item label="二级分类" label-width="150" right-icon="arrow-right">
				
						<u-input v-model="value" placeholder="请选择" type="select" class="form-field-select"
							@click="centerFormSelectOpen1" />
						<u-action-sheet :list="centerFormSelectList" v-model="centerFormShow1"
							@click="centerFormSelectCallback1"></u-action-sheet>
					</u-form-item>
					<!-- <u-gap height="20" bg-color="#f5f5f5"></u-gap>
					<u-form-item label="开始时间" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item>
					<u-form-item label="结束时间" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item> -->
					<u-form-item label="三级分类:" label-width="150">
						<u-input placeholder="请输入" type="input" v-model="centerForm.type"/>
					</u-form-item>
					<u-form-item label="颜色:" label-width="150">
						<u-input placeholder="请输入" type="input" v-model="centerForm.color"/>
					</u-form-item>
					<u-form-item label="图片" label-width="150">
						<u-upload :action="action"  ></u-upload>
					</u-form-item>
					

				</u-form>
			</u-modal>
			<u-gap height="20" bg-color="#f5f5f5"></u-gap>
			<u-row gutter="6" justify="center">
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="leftOpen" type="primary" shape="square" size="medium"
						:ripple="true" ripple-bg-color="#909399">
						添加一级分类
					</u-button>
				</u-col>
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="rightOpen" type="success" shape="square" size="medium"
						:ripple="true" ripple-bg-color="#909399">
						添加二级分类
					</u-button>
				</u-col>
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="centerOpen" type="warning" shape="square"
						size="medium" :ripple="true" ripple-bg-color="#909399">
						添加三级分类
					</u-button>
				</u-col>
			</u-row>
			
			<u-row gutter="32" class="bottom-box" justify="center">
				<u-col span="10">
					<view>
						<u-button type="primary" shape="circle" @click="navTo('/pages/sys/home/index')">确定</u-button>
					</view>
				</u-col>
			</u-row>
		</view>
		<view v-if="current === 1">
			<!-- <view class="search">
				<u-search v-model="keyWords" @custom="search" @search="search"></u-search>
			</view>-->
			<!--			种类列表界面-->

			<u-card :title-color="'#40c9c6'" :sub-title="item.createDatetime" :title="item.varieties"
				v-for="(item, index) in titleList" :key="index" @head-click="open(item.id)">

				<view class="" slot="body">
					<u-read-more ref="uReadMore" :toggle="true" open-text="收起" close-text="展开">
						<view class="u-body-item  u-border-bottom u-col-between u-p-t-0"
							v-for="(item1, index1) in contentList[item.id]" :key="index1">

							<u-row gutter="2">
								<u-col span="4">
									<view class="u-body-item-title u-line-2">{{item1.type}}</view>
								</u-col>

								<u-col span="5">
									<view class="u-body-item-title u-line-2">{{item1.createDatetime}}</view>
								</u-col>
								<u-col span="3">
									<image
										src="https://img11.360buyimg.com/n7/jfs/t1/94448/29/2734/524808/5dd4cc16E990dfb6b/59c256f85a8c3757.jpg"
										mode="aspectFill"></image>
								</u-col>
							</u-row>
						</view>
					</u-read-more>

				</view>
				<view class="" slot="foot">
					<u-icon name="chat-fill" size="34" color="" label="30评论"></u-icon>
				</view>
			</u-card>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				buttonStyle: {
					width: '130rpx',
					alignItem: 'center',
					display: 'flex'
				},
				value: '',
				centerFormValue: '',
				modalClose: true,
				leftShow: false,
				rightShow: false,
				centerShow: false,
				action: 'http://www.example.com/upload',
				list: [{
					name: '添加品种'
				}, {
					name: '品种列表',
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

				keyWords: '',
				form: {},
				titleList: [],
				//二级分类数组
				varietiesList: {},
				contentList: {},
				// 查询参数
				queryParams: {
					pageNum: 1,
					pageSize: 10,
					type: null,
					color: null,
					ascriptionId: null,
					varietiesId: null,
					creator: null,
					createDatetime: null,
					modifyDatetime: null
				},
				clickIndex: 0,
				// 一级分类表单参数
				leftForm: {},
				// 二级分类表单参数
				rightForm: {},
				// 二级分类表单中：一级分类下拉框;下拉列表值
				rightFormShow1: false,
				rightFormSelectList: [],
				// 三级分类表单参数
				centerForm: {},
				centerFormShow1: false,
				centerFormSelectList: [],
				typeList: {},
			}
		},

		onLoad() {
			this.getList()
		},
		created() {},
		methods: {
			// 查询二级列表
			getList() {
				this.$u.api.repository.titleListData({}).then(res => {
					this.titleList = res.rows;
					for (let i = 0; i < this.titleList.length; i++) {
						this.queryParams.varietiesId = this.titleList[i].id;
						this.getContentList(this.queryParams);
					}

				});


			},
			//获取三级列表
			getContentList(queryParams) {
				let vid = queryParams.varietiesId;
				this.$u.api.repository.contentListData(
					queryParams
				).then(res => {
					// this.contentList = res.rows;
					let conList = [];
					conList = res.rows;
					// let listdetail = {'id':queryParams.varietiesId,'conList':conList};
					this.contentList[vid] = conList;

					this.$forceUpdate();
				});
			},

			change(index) {
				this.current = index;
			},

			navTo(url) {
				uni.navigateTo({
					url: url
				});
			},
			leftOpen() {
				this.leftShow = true;
			},
			rightOpen() {
				this.rightShow = true;
				this.$u.api.repository.ascriptionList({}).then(res => {
					this.rightFormSelectList = [];
					for (var i = 0; i < res.rows.length; i++) {
						this.varietiesList[res.rows[i].ascription] = res.rows[i].id;
						this.rightFormSelectList.push({
							text: res.rows[i].ascription
						})
					}
				})
			},
			centerOpen() {

				this.centerShow = true;
				//查二级分类对应的一级分类，自动填写一级分类
				

				this.$u.api.repository.varietiesList({}).then(res => {

					this.centerFormSelectList = [];

					for (var i = 0; i < res.rows.length; i++) {

						this.typeList[res.rows[i].varieties] = res.rows[i].id;

						this.centerFormSelectList.push({
							text: res.rows[i].varieties
						})

					}

				})

			},
			rightFormSelectOpen1() {
				this.rightFormShow1 = true;
			},
			centerFormSelectOpen1() {
				this.centerFormShow1 = true;
			},
			
			// 点击actionSheet回调
			rightFormSelectCallback1(index) {
				this.value = this.rightFormSelectList[index].text;
			},
			// 点击actionSheet回调
			centerFormSelectCallback1(index) {
				this.value = this.centerFormSelectList[index].text;
			},
			//一级分类表单提交
			submitLeftForm() {
				this.$u.api.repository.submitLeftForm(JSON.stringify(this.leftForm));
			},
			// 二级分类表单提交
			submitRightForm() {
				this.rightForm.ascriptionId = this.varietiesList[this.value];
				this.$u.api.repository.submitRightForm(JSON.stringify(this.rightForm));
			},
			// 三级分类表单提交
			submitCenterForm() {
				this.centerForm.varietiesId = this.typeList[this.value];
				this.$u.api.repository.submitCenterForm(JSON.stringify(this.centerForm));
			}
		}
	}
</script>
<style lang="scss" scoped>
	@import '../index.scss';

	page {
		background-color: #f5f5f5;
	}

	.u-card-wrap {
		background-color: $u-bg-color;
		padding: 1px;
	}

	.u-body-item {
		font-size: 32rpx;
		color: #333;
		padding: 20rpx 10rpx;
	}

	.u-body-item image {
		width: 100rpx;
		flex: 0 0 100rpx;
		height: 100rpx;
		border-radius: 8rpx;
		margin-left: 12rpx;
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
