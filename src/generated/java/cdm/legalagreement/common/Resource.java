package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.ResourceMeta;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaResourceTypeEnum.FieldWithMetaResourceTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the resource that contains the media representation of a business event (i.e used for stating the Publicly Available Information). For example, can describe a file or a URL that represents the event. This type is an extended version of a type defined by RIXML (www.rixml.org).  Rosetta restricts the FpML implementation by not providing the ability to associated a document in hexadecimalBinary or base64Binary until such time that actual use cases will come up.
 * @version ${project.version}
 */
@RosettaClass

public interface Resource extends RosettaModelObject {
	Resource build();
	Resource.ResourceBuilder toBuilder();
	
	/**
	 * Any additional comments that are deemed necessary. For example, which software version is required to open the document? Or, how does this resource relate to the others for this event?
	 */
	String getComments();
	/**
	 * Indicates the language of the resource, described using the ISO 639-2/T Code.
	 */
	FieldWithMetaString getLanguage();
	/**
	 * Indicates the length of the resource. For example, if the resource were a PDF file, the length would be in pages.
	 */
	ResourceLength getLength();
	/**
	 * Indicates the type of media used to store the content. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
	 */
	FieldWithMetaString getMimeType();
	/**
	 * The name of the resource.  It is specified as a NormalizedString in FpML.
	 */
	String getName();
	/**
	 * The unique identifier of the resource within the event. FpML specifies this element of type resourceIdScheme but with no specified value.
	 */
	FieldWithMetaString getResourceId();
	/**
	 * A description of the type of the resource, e.g. a confirmation.
	 */
	FieldWithMetaResourceTypeEnum getResourceType();
	/**
	 * Indicates the size of the resource in bytes. It could be used by the end user to estimate the download time and storage needs.
	 */
	BigDecimal getSizeInBytes();
	/**
	 * Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
	 */
	String getString();
	/**
	 * Indicates where the resource can be found, as a URL that references the information on a web server accessible to the message recipient.
	 */
	String getUrl();
	final static ResourceMeta metaData = new ResourceMeta();
	
	@Override
	default RosettaMetaData<? extends Resource> metaData() {
		return metaData;
	} 
			
	static Resource.ResourceBuilder builder() {
		return new Resource.ResourceBuilderImpl();
	}
	
	default Class<? extends Resource> getType() {
		return Resource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processor.processBasic(path.newSubPath("sizeInBytes"), BigDecimal.class, getSizeInBytes(), this);
		processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
		processor.processBasic(path.newSubPath("url"), String.class, getUrl(), this);
		
		processRosetta(path.newSubPath("language"), processor, FieldWithMetaString.class, getLanguage());
		processRosetta(path.newSubPath("length"), processor, ResourceLength.class, getLength());
		processRosetta(path.newSubPath("mimeType"), processor, FieldWithMetaString.class, getMimeType());
		processRosetta(path.newSubPath("resourceId"), processor, FieldWithMetaString.class, getResourceId());
		processRosetta(path.newSubPath("resourceType"), processor, FieldWithMetaResourceTypeEnum.class, getResourceType());
	}
	
	
	interface ResourceBuilder extends Resource, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateLanguage();
		FieldWithMetaStringBuilder getLanguage();
		ResourceLength.ResourceLengthBuilder getOrCreateLength();
		ResourceLength.ResourceLengthBuilder getLength();
		FieldWithMetaStringBuilder getOrCreateMimeType();
		FieldWithMetaStringBuilder getMimeType();
		FieldWithMetaStringBuilder getOrCreateResourceId();
		FieldWithMetaStringBuilder getResourceId();
		FieldWithMetaResourceTypeEnumBuilder getOrCreateResourceType();
		FieldWithMetaResourceTypeEnumBuilder getResourceType();
		Resource.ResourceBuilder setComments(String comments);
		Resource.ResourceBuilder setLanguage(FieldWithMetaString language);
		Resource.ResourceBuilder setLanguageValue(String language);
		Resource.ResourceBuilder setLength(ResourceLength length);
		Resource.ResourceBuilder setMimeType(FieldWithMetaString mimeType);
		Resource.ResourceBuilder setMimeTypeValue(String mimeType);
		Resource.ResourceBuilder setName(String name);
		Resource.ResourceBuilder setResourceId(FieldWithMetaString resourceId);
		Resource.ResourceBuilder setResourceIdValue(String resourceId);
		Resource.ResourceBuilder setResourceType(FieldWithMetaResourceTypeEnum resourceType);
		Resource.ResourceBuilder setResourceTypeValue(ResourceTypeEnum resourceType);
		Resource.ResourceBuilder setSizeInBytes(BigDecimal sizeInBytes);
		Resource.ResourceBuilder setString(String string);
		Resource.ResourceBuilder setUrl(String url);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("comments"), String.class, getComments(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processor.processBasic(path.newSubPath("sizeInBytes"), BigDecimal.class, getSizeInBytes(), this);
			processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
			processor.processBasic(path.newSubPath("url"), String.class, getUrl(), this);
			
			processRosetta(path.newSubPath("language"), processor, FieldWithMetaStringBuilder.class, getLanguage());
			processRosetta(path.newSubPath("length"), processor, ResourceLength.ResourceLengthBuilder.class, getLength());
			processRosetta(path.newSubPath("mimeType"), processor, FieldWithMetaStringBuilder.class, getMimeType());
			processRosetta(path.newSubPath("resourceId"), processor, FieldWithMetaStringBuilder.class, getResourceId());
			processRosetta(path.newSubPath("resourceType"), processor, FieldWithMetaResourceTypeEnumBuilder.class, getResourceType());
		}
		
	}
	
	//Resource.ResourceImpl
	class ResourceImpl implements Resource {
		private final String comments;
		private final FieldWithMetaString language;
		private final ResourceLength length;
		private final FieldWithMetaString mimeType;
		private final String name;
		private final FieldWithMetaString resourceId;
		private final FieldWithMetaResourceTypeEnum resourceType;
		private final BigDecimal sizeInBytes;
		private final String string;
		private final String url;
		
		protected ResourceImpl(Resource.ResourceBuilder builder) {
			this.comments = builder.getComments();
			this.language = ofNullable(builder.getLanguage()).map(f->f.build()).orElse(null);
			this.length = ofNullable(builder.getLength()).map(f->f.build()).orElse(null);
			this.mimeType = ofNullable(builder.getMimeType()).map(f->f.build()).orElse(null);
			this.name = builder.getName();
			this.resourceId = ofNullable(builder.getResourceId()).map(f->f.build()).orElse(null);
			this.resourceType = ofNullable(builder.getResourceType()).map(f->f.build()).orElse(null);
			this.sizeInBytes = builder.getSizeInBytes();
			this.string = builder.getString();
			this.url = builder.getUrl();
		}
		
		@Override
		public String getComments() {
			return comments;
		}
		
		@Override
		public FieldWithMetaString getLanguage() {
			return language;
		}
		
		@Override
		public ResourceLength getLength() {
			return length;
		}
		
		@Override
		public FieldWithMetaString getMimeType() {
			return mimeType;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaString getResourceId() {
			return resourceId;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnum getResourceType() {
			return resourceType;
		}
		
		@Override
		public BigDecimal getSizeInBytes() {
			return sizeInBytes;
		}
		
		@Override
		public String getString() {
			return string;
		}
		
		@Override
		public String getUrl() {
			return url;
		}
		
		@Override
		public Resource build() {
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder toBuilder() {
			Resource.ResourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Resource.ResourceBuilder builder) {
			ofNullable(getComments()).ifPresent(builder::setComments);
			ofNullable(getLanguage()).ifPresent(builder::setLanguage);
			ofNullable(getLength()).ifPresent(builder::setLength);
			ofNullable(getMimeType()).ifPresent(builder::setMimeType);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getResourceId()).ifPresent(builder::setResourceId);
			ofNullable(getResourceType()).ifPresent(builder::setResourceType);
			ofNullable(getSizeInBytes()).ifPresent(builder::setSizeInBytes);
			ofNullable(getString()).ifPresent(builder::setString);
			ofNullable(getUrl()).ifPresent(builder::setUrl);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Resource _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!Objects.equals(length, _that.getLength())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(resourceId, _that.getResourceId())) return false;
			if (!Objects.equals(resourceType, _that.getResourceType())) return false;
			if (!Objects.equals(sizeInBytes, _that.getSizeInBytes())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(url, _that.getUrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (length != null ? length.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (resourceId != null ? resourceId.hashCode() : 0);
			_result = 31 * _result + (resourceType != null ? resourceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sizeInBytes != null ? sizeInBytes.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (url != null ? url.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Resource {" +
				"comments=" + this.comments + ", " +
				"language=" + this.language + ", " +
				"length=" + this.length + ", " +
				"mimeType=" + this.mimeType + ", " +
				"name=" + this.name + ", " +
				"resourceId=" + this.resourceId + ", " +
				"resourceType=" + this.resourceType + ", " +
				"sizeInBytes=" + this.sizeInBytes + ", " +
				"string=" + this.string + ", " +
				"url=" + this.url +
			'}';
		}
	}
	
	//Resource.ResourceBuilderImpl
	class ResourceBuilderImpl implements Resource.ResourceBuilder {
	
		protected String comments;
		protected FieldWithMetaStringBuilder language;
		protected ResourceLength.ResourceLengthBuilder length;
		protected FieldWithMetaStringBuilder mimeType;
		protected String name;
		protected FieldWithMetaStringBuilder resourceId;
		protected FieldWithMetaResourceTypeEnumBuilder resourceType;
		protected BigDecimal sizeInBytes;
		protected String string;
		protected String url;
	
		public ResourceBuilderImpl() {
		}
	
		@Override
		public String getComments() {
			return comments;
		}
		
		@Override
		public FieldWithMetaStringBuilder getLanguage() {
			return language;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateLanguage() {
			FieldWithMetaStringBuilder result;
			if (language!=null) {
				result = language;
			}
			else {
				result = language = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public ResourceLength.ResourceLengthBuilder getLength() {
			return length;
		}
		
		@Override
		public ResourceLength.ResourceLengthBuilder getOrCreateLength() {
			ResourceLength.ResourceLengthBuilder result;
			if (length!=null) {
				result = length;
			}
			else {
				result = length = ResourceLength.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getMimeType() {
			return mimeType;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateMimeType() {
			FieldWithMetaStringBuilder result;
			if (mimeType!=null) {
				result = mimeType;
			}
			else {
				result = mimeType = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaStringBuilder getResourceId() {
			return resourceId;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateResourceId() {
			FieldWithMetaStringBuilder result;
			if (resourceId!=null) {
				result = resourceId;
			}
			else {
				result = resourceId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnumBuilder getResourceType() {
			return resourceType;
		}
		
		@Override
		public FieldWithMetaResourceTypeEnumBuilder getOrCreateResourceType() {
			FieldWithMetaResourceTypeEnumBuilder result;
			if (resourceType!=null) {
				result = resourceType;
			}
			else {
				result = resourceType = FieldWithMetaResourceTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getSizeInBytes() {
			return sizeInBytes;
		}
		
		@Override
		public String getString() {
			return string;
		}
		
		@Override
		public String getUrl() {
			return url;
		}
		
	
		@Override
		public Resource.ResourceBuilder setComments(String comments) {
			this.comments = comments==null?null:comments;
			return this;
		}
		@Override
		public Resource.ResourceBuilder setLanguage(FieldWithMetaString language) {
			this.language = language==null?null:language.toBuilder();
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder setLanguageValue(String language) {
			this.getOrCreateLanguage().setValue(language);
			return this;
		}
		@Override
		public Resource.ResourceBuilder setLength(ResourceLength length) {
			this.length = length==null?null:length.toBuilder();
			return this;
		}
		@Override
		public Resource.ResourceBuilder setMimeType(FieldWithMetaString mimeType) {
			this.mimeType = mimeType==null?null:mimeType.toBuilder();
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder setMimeTypeValue(String mimeType) {
			this.getOrCreateMimeType().setValue(mimeType);
			return this;
		}
		@Override
		public Resource.ResourceBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		public Resource.ResourceBuilder setResourceId(FieldWithMetaString resourceId) {
			this.resourceId = resourceId==null?null:resourceId.toBuilder();
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder setResourceIdValue(String resourceId) {
			this.getOrCreateResourceId().setValue(resourceId);
			return this;
		}
		@Override
		public Resource.ResourceBuilder setResourceType(FieldWithMetaResourceTypeEnum resourceType) {
			this.resourceType = resourceType==null?null:resourceType.toBuilder();
			return this;
		}
		
		@Override
		public Resource.ResourceBuilder setResourceTypeValue(ResourceTypeEnum resourceType) {
			this.getOrCreateResourceType().setValue(resourceType);
			return this;
		}
		@Override
		public Resource.ResourceBuilder setSizeInBytes(BigDecimal sizeInBytes) {
			this.sizeInBytes = sizeInBytes==null?null:sizeInBytes;
			return this;
		}
		@Override
		public Resource.ResourceBuilder setString(String string) {
			this.string = string==null?null:string;
			return this;
		}
		@Override
		public Resource.ResourceBuilder setUrl(String url) {
			this.url = url==null?null:url;
			return this;
		}
		
		@Override
		public Resource build() {
			return new Resource.ResourceImpl(this);
		}
		
		@Override
		public Resource.ResourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Resource.ResourceBuilder prune() {
			if (language!=null && !language.prune().hasData()) language = null;
			if (length!=null && !length.prune().hasData()) length = null;
			if (mimeType!=null && !mimeType.prune().hasData()) mimeType = null;
			if (resourceId!=null && !resourceId.prune().hasData()) resourceId = null;
			if (resourceType!=null && !resourceType.prune().hasData()) resourceType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getComments()!=null) return true;
			if (getLanguage()!=null) return true;
			if (getLength()!=null && getLength().hasData()) return true;
			if (getMimeType()!=null) return true;
			if (getName()!=null) return true;
			if (getResourceId()!=null) return true;
			if (getResourceType()!=null) return true;
			if (getSizeInBytes()!=null) return true;
			if (getString()!=null) return true;
			if (getUrl()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Resource.ResourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Resource.ResourceBuilder o = (Resource.ResourceBuilder) other;
			
			merger.mergeRosetta(getLanguage(), o.getLanguage(), this::setLanguage);
			merger.mergeRosetta(getLength(), o.getLength(), this::setLength);
			merger.mergeRosetta(getMimeType(), o.getMimeType(), this::setMimeType);
			merger.mergeRosetta(getResourceId(), o.getResourceId(), this::setResourceId);
			merger.mergeRosetta(getResourceType(), o.getResourceType(), this::setResourceType);
			
			merger.mergeBasic(getComments(), o.getComments(), this::setComments);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getSizeInBytes(), o.getSizeInBytes(), this::setSizeInBytes);
			merger.mergeBasic(getString(), o.getString(), this::setString);
			merger.mergeBasic(getUrl(), o.getUrl(), this::setUrl);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Resource _that = getType().cast(o);
		
			if (!Objects.equals(comments, _that.getComments())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!Objects.equals(length, _that.getLength())) return false;
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(resourceId, _that.getResourceId())) return false;
			if (!Objects.equals(resourceType, _that.getResourceType())) return false;
			if (!Objects.equals(sizeInBytes, _that.getSizeInBytes())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(url, _that.getUrl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (comments != null ? comments.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (length != null ? length.hashCode() : 0);
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (resourceId != null ? resourceId.hashCode() : 0);
			_result = 31 * _result + (resourceType != null ? resourceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sizeInBytes != null ? sizeInBytes.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (url != null ? url.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceBuilder {" +
				"comments=" + this.comments + ", " +
				"language=" + this.language + ", " +
				"length=" + this.length + ", " +
				"mimeType=" + this.mimeType + ", " +
				"name=" + this.name + ", " +
				"resourceId=" + this.resourceId + ", " +
				"resourceType=" + this.resourceType + ", " +
				"sizeInBytes=" + this.sizeInBytes + ", " +
				"string=" + this.string + ", " +
				"url=" + this.url +
			'}';
		}
	}
}
