package gaoyuan.common.fdfs;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

/*
 * 上传图片
 */
public class FastDFSUtils {
	 public static String uploadPic(byte[]file_buff,String name,long size){
		 String path=null;
		 //ClientGloble 读配置文件
		 ClassPathResource resource =new ClassPathResource("fdfs_client.conf");
		 try {
			ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
			//老大的客户端
			TrackerClient trackerClient=new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();
			StorageServer storageServer=null;
			StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
			String file_ext_name=FilenameUtils.getExtension(name);
			NameValuePair[] nvp=new NameValuePair[3];
			nvp[0]=new NameValuePair("fileName",name);
			nvp[1]=new NameValuePair("fileExt",file_ext_name);
			nvp[2]=new NameValuePair("fileSize",size+"");
//			/group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
			 path = storageClient1.upload_file1(file_buff, file_ext_name, nvp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 return path;
	 }
}
