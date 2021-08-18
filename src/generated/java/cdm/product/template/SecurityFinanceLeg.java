package cdm.product.template;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.settlement.DeliveryMethodEnum;
import cdm.product.template.meta.SecurityFinanceLegMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines each security movement of a security financing transaction.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityFinanceLeg extends RosettaModelObject, GlobalKey {
	SecurityFinanceLeg build();
	SecurityFinanceLeg.SecurityFinanceLegBuilder toBuilder();
	
	/**
	 * Specifies a delivery method for the security movement.
	 */
	DeliveryMethodEnum getDeliveryMethod();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Settlement date of the security movement.
	 */
	AdjustableOrRelativeDate getSettlementDate();
	final static SecurityFinanceLegMeta metaData = new SecurityFinanceLegMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityFinanceLeg> metaData() {
		return metaData;
	} 
			
	static SecurityFinanceLeg.SecurityFinanceLegBuilder builder() {
		return new SecurityFinanceLeg.SecurityFinanceLegBuilderImpl();
	}
	
	default Class<? extends SecurityFinanceLeg> getType() {
		return SecurityFinanceLeg.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryMethod"), DeliveryMethodEnum.class, getDeliveryMethod(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
	}
	
	
	interface SecurityFinanceLegBuilder extends SecurityFinanceLeg, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		SecurityFinanceLeg.SecurityFinanceLegBuilder setDeliveryMethod(DeliveryMethodEnum deliveryMethod);
		SecurityFinanceLeg.SecurityFinanceLegBuilder setMeta(MetaFields meta);
		SecurityFinanceLeg.SecurityFinanceLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("deliveryMethod"), DeliveryMethodEnum.class, getDeliveryMethod(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
		}
		
	}
	
	//SecurityFinanceLeg.SecurityFinanceLegImpl
	class SecurityFinanceLegImpl implements SecurityFinanceLeg {
		private final DeliveryMethodEnum deliveryMethod;
		private final MetaFields meta;
		private final AdjustableOrRelativeDate settlementDate;
		
		protected SecurityFinanceLegImpl(SecurityFinanceLeg.SecurityFinanceLegBuilder builder) {
			this.deliveryMethod = builder.getDeliveryMethod();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DeliveryMethodEnum getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public SecurityFinanceLeg build() {
			return this;
		}
		
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder toBuilder() {
			SecurityFinanceLeg.SecurityFinanceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityFinanceLeg.SecurityFinanceLegBuilder builder) {
			ofNullable(getDeliveryMethod()).ifPresent(builder::setDeliveryMethod);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityFinanceLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityFinanceLeg {" +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"meta=" + this.meta + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}
	
	//SecurityFinanceLeg.SecurityFinanceLegBuilderImpl
	class SecurityFinanceLegBuilderImpl implements SecurityFinanceLeg.SecurityFinanceLegBuilder, GlobalKeyBuilder {
	
		protected DeliveryMethodEnum deliveryMethod;
		protected MetaFields.MetaFieldsBuilder meta;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
	
		public SecurityFinanceLegBuilderImpl() {
		}
	
		@Override
		public DeliveryMethodEnum getDeliveryMethod() {
			return deliveryMethod;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder setDeliveryMethod(DeliveryMethodEnum deliveryMethod) {
			this.deliveryMethod = deliveryMethod==null?null:deliveryMethod;
			return this;
		}
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public SecurityFinanceLeg build() {
			return new SecurityFinanceLeg.SecurityFinanceLegImpl(this);
		}
		
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryMethod()!=null) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityFinanceLeg.SecurityFinanceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityFinanceLeg.SecurityFinanceLegBuilder o = (SecurityFinanceLeg.SecurityFinanceLegBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			merger.mergeBasic(getDeliveryMethod(), o.getDeliveryMethod(), this::setDeliveryMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityFinanceLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryMethod, _that.getDeliveryMethod())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryMethod != null ? deliveryMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityFinanceLegBuilder {" +
				"deliveryMethod=" + this.deliveryMethod + ", " +
				"meta=" + this.meta + ", " +
				"settlementDate=" + this.settlementDate +
			'}';
		}
	}
}
