package gaoyuan.core.service.product;

import org.springframework.stereotype.Service;

import gaoyuan.common.fdfs.FastDFSUtils;

@Service("uploadService")
public class UploadServiceImpl implements UploadService{
	//上传图片
	public String uploadPic(byte[]file_buff,String name,long size){
		return FastDFSUtils.uploadPic(file_buff, name, size);
	}
}
