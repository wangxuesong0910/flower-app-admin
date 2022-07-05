import request from '@/utils/request'

// 查询花的品种：玫瑰、百合等等(二级分类)列表
export function listVarieties(query) {
  return request({
    url: '/erp/varieties/list',
    method: 'get',
    params: query
  })
}

// 查询花的品种：玫瑰、百合等等(二级分类)详细
export function getVarieties(id) {
  return request({
    url: '/erp/varieties/' + id,
    method: 'get'
  })
}

// 新增花的品种：玫瑰、百合等等(二级分类)
export function addVarieties(data) {
  return request({
    url: '/erp/varieties',
    method: 'post',
    data: data
  })
}

// 修改花的品种：玫瑰、百合等等(二级分类)
export function updateVarieties(data) {
  return request({
    url: '/erp/varieties',
    method: 'put',
    data: data
  })
}

// 删除花的品种：玫瑰、百合等等(二级分类)
export function delVarieties(id) {
  return request({
    url: '/erp/varieties/' + id,
    method: 'delete'
  })
}
