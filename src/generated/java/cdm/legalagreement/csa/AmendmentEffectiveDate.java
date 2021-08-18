package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AmendmentEffectiveDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision. 
 * @version ${project.version}
 */
@RosettaClass

public interface AmendmentEffectiveDate extends RosettaModelObject {
	AmendmentEffectiveDate build();
	AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder();
	
	/**
	 * The effective date of the Amendment to Termination Currency when specified as a non normalized custom provision.
	 */
	String getCustomProvision();
	/**
	 * The effective date of the Amendment to Termination Currency when specified as an actual date.
	 */
	Date getDate();
	/**
	 * The effective date of the Amendment to Termination Currency when specified as relative to another date (e.g. the annex date).
	 */
	AmendmentEffectiveDateEnum getSpecificDate();
	final static AmendmentEffectiveDateMeta metaData = new AmendmentEffectiveDateMeta();
	
	@Override
	default RosettaMetaData<? extends AmendmentEffectiveDate> metaData() {
		return metaData;
	} 
			
	static AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder() {
		return new AmendmentEffectiveDate.AmendmentEffectiveDateBuilderImpl();
	}
	
	default Class<? extends AmendmentEffectiveDate> getType() {
		return AmendmentEffectiveDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("specificDate"), AmendmentEffectiveDateEnum.class, getSpecificDate(), this);
		
	}
	
	
	interface AmendmentEffectiveDateBuilder extends AmendmentEffectiveDate, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setCustomProvision(String customProvision);
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setDate(Date date);
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setSpecificDate(AmendmentEffectiveDateEnum specificDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("specificDate"), AmendmentEffectiveDateEnum.class, getSpecificDate(), this);
			
		}
		
	}
	
	//AmendmentEffectiveDate.AmendmentEffectiveDateImpl
	class AmendmentEffectiveDateImpl implements AmendmentEffectiveDate {
		private final String customProvision;
		private final Date date;
		private final AmendmentEffectiveDateEnum specificDate;
		
		protected AmendmentEffectiveDateImpl(AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder) {
			this.customProvision = builder.getCustomProvision();
			this.date = builder.getDate();
			this.specificDate = builder.getSpecificDate();
		}
		
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public AmendmentEffectiveDateEnum getSpecificDate() {
			return specificDate;
		}
		
		@Override
		public AmendmentEffectiveDate build() {
			return this;
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder() {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmendmentEffectiveDate.AmendmentEffectiveDateBuilder builder) {
			ofNullable(getCustomProvision()).ifPresent(builder::setCustomProvision);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getSpecificDate()).ifPresent(builder::setSpecificDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmendmentEffectiveDate _that = getType().cast(o);
		
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (specificDate != null ? specificDate.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentEffectiveDate {" +
				"customProvision=" + this.customProvision + ", " +
				"date=" + this.date + ", " +
				"specificDate=" + this.specificDate +
			'}';
		}
	}
	
	//AmendmentEffectiveDate.AmendmentEffectiveDateBuilderImpl
	class AmendmentEffectiveDateBuilderImpl implements AmendmentEffectiveDate.AmendmentEffectiveDateBuilder {
	
		protected String customProvision;
		protected Date date;
		protected AmendmentEffectiveDateEnum specificDate;
	
		public AmendmentEffectiveDateBuilderImpl() {
		}
	
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public AmendmentEffectiveDateEnum getSpecificDate() {
			return specificDate;
		}
		
	
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setCustomProvision(String customProvision) {
			this.customProvision = customProvision==null?null:customProvision;
			return this;
		}
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder setSpecificDate(AmendmentEffectiveDateEnum specificDate) {
			this.specificDate = specificDate==null?null:specificDate;
			return this;
		}
		
		@Override
		public AmendmentEffectiveDate build() {
			return new AmendmentEffectiveDate.AmendmentEffectiveDateImpl(this);
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomProvision()!=null) return true;
			if (getDate()!=null) return true;
			if (getSpecificDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder o = (AmendmentEffectiveDate.AmendmentEffectiveDateBuilder) other;
			
			
			merger.mergeBasic(getCustomProvision(), o.getCustomProvision(), this::setCustomProvision);
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getSpecificDate(), o.getSpecificDate(), this::setSpecificDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmendmentEffectiveDate _that = getType().cast(o);
		
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(specificDate, _that.getSpecificDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (specificDate != null ? specificDate.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmendmentEffectiveDateBuilder {" +
				"customProvision=" + this.customProvision + ", " +
				"date=" + this.date + ", " +
				"specificDate=" + this.specificDate +
			'}';
		}
	}
}
