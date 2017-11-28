/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	// 界面语言，默认为 'en'
    config.language = 'zh-cn';
    // 设置宽高
    config.height = 400;
 // 图片上传配置  
    config.filebrowserUploadUrl = '/upload?type=File';  
    config.filebrowserImageUploadUrl = '/upload?type=Image';  
    config.filebrowserFlashUploadUrl = '/upload?type=Flash';  

};