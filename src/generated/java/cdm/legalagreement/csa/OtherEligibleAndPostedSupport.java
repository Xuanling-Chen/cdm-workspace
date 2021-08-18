package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.OtherEligibleAndPostedSupportMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the Other Eligible Support elections associated Initial and Variation margin agreements.
 * @version ${project.version}
 */
@RosettaClass

public interface OtherEligibleAndPostedSupport extends RosettaModelObject {
	OtherEligibleAndPostedSupport build();
	OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder();
	
	/**
	 * The definition of &#39;Transfer&#39; with respect to Other Eligible Support (IM) and Other Posted Support (IM).
	 */
	Boolean getApplicableTransfer();
	/**
	 * The definition of &#39;Value&#39; with respect to Other Eligible Support (IM) and Other Posted Support (IM).
	 */
	Boolean getApplicableValue();
	final static OtherEligibleAndPostedSupportMeta metaData = new OtherEligibleAndPostedSupportMeta();
	
	@Override
	default RosettaMetaData<? extends OtherEligibleAndPostedSupport> metaData() {
		return metaData;
	} 
			
	static OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder() {
		return new OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilderImpl();
	}
	
	default Class<? extends OtherEligibleAndPostedSupport> getType() {
		return OtherEligibleAndPostedSupport.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicableTransfer"), Boolean.class, getApplicableTransfer(), this);
		processor.processBasic(path.newSubPath("applicableValue"), Boolean.class, getApplicableValue(), this);
		
	}
	
	
	interface OtherEligibleAndPostedSupportBuilder extends OtherEligibleAndPostedSupport, RosettaModelObjectBuilder {
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableTransfer(Boolean applicableTransfer);
		OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableValue(Boolean applicableValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("applicableTransfer"), Boolean.class, getApplicableTransfer(), this);
			processor.processBasic(path.newSubPath("applicableValue"), Boolean.class, getApplicableValue(), this);
			
		}
		
	}
	
	//OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportImpl
	class OtherEligibleAndPostedSupportImpl implements OtherEligibleAndPostedSupport {
		private final Boolean applicableTransfer;
		private final Boolean applicableValue;
		
		protected OtherEligibleAndPostedSupportImpl(OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder) {
			this.applicableTransfer = builder.getApplicableTransfer();
			this.applicableValue = builder.getApplicableValue();
		}
		
		@Override
		public Boolean getApplicableTransfer() {
			return applicableTransfer;
		}
		
		@Override
		public Boolean getApplicableValue() {
			return applicableValue;
		}
		
		@Override
		public OtherEligibleAndPostedSupport build() {
			return this;
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder() {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder builder) {
			ofNullable(getApplicableTransfer()).ifPresent(builder::setApplicableTransfer);
			ofNullable(getApplicableValue()).ifPresent(builder::setApplicableValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherEligibleAndPostedSupport _that = getType().cast(o);
		
			if (!Objects.equals(applicableTransfer, _that.getApplicableTransfer())) return false;
			if (!Objects.equals(applicableValue, _that.getApplicableValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableTransfer != null ? applicableTransfer.hashCode() : 0);
			_result = 31 * _result + (applicableValue != null ? applicableValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherEligibleAndPostedSupport {" +
				"applicableTransfer=" + this.applicableTransfer + ", " +
				"applicableValue=" + this.applicableValue +
			'}';
		}
	}
	
	//OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilderImpl
	class OtherEligibleAndPostedSupportBuilderImpl implements OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder {
	
		protected Boolean applicableTransfer;
		protected Boolean applicableValue;
	
		public OtherEligibleAndPostedSupportBuilderImpl() {
		}
	
		@Override
		public Boolean getApplicableTransfer() {
			return applicableTransfer;
		}
		
		@Override
		public Boolean getApplicableValue() {
			return applicableValue;
		}
		
	
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableTransfer(Boolean applicableTransfer) {
			this.applicableTransfer = applicableTransfer==null?null:applicableTransfer;
			return this;
		}
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder setApplicableValue(Boolean applicableValue) {
			this.applicableValue = applicableValue==null?null:applicableValue;
			return this;
		}
		
		@Override
		public OtherEligibleAndPostedSupport build() {
			return new OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportImpl(this);
		}
		
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicableTransfer()!=null) return true;
			if (getApplicableValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder o = (OtherEligibleAndPostedSupport.OtherEligibleAndPostedSupportBuilder) other;
			
			
			merger.mergeBasic(getApplicableTransfer(), o.getApplicableTransfer(), this::setApplicableTransfer);
			merger.mergeBasic(getApplicableValue(), o.getApplicableValue(), this::setApplicableValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherEligibleAndPostedSupport _that = getType().cast(o);
		
			if (!Objects.equals(applicableTransfer, _that.getApplicableTransfer())) return false;
			if (!Objects.equals(applicableValue, _that.getApplicableValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicableTransfer != null ? applicableTransfer.hashCode() : 0);
			_result = 31 * _result + (applicableValue != null ? applicableValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherEligibleAndPostedSupportBuilder {" +
				"applicableTransfer=" + this.applicableTransfer + ", " +
				"applicableValue=" + this.applicableValue +
			'}';
		}
	}
}
