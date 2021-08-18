package cdm.product.template;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.product.template.meta.PassThroughItemMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Class to represent a single pass through payment.
 * @version ${project.version}
 */
@RosettaClass

public interface PassThroughItem extends RosettaModelObject {
	PassThroughItem build();
	PassThroughItem.PassThroughItemBuilder toBuilder();
	
	/**
	 * Percentage of payments from the underlier which are passed through.
	 */
	BigDecimal getPassThroughPercentage();
	/**
	 * This attribute doesn&#39;t exists in the FpML construct, which makes use of the PayerReceiver.model group.
	 */
	PayerReceiver getPayerReceiver();
	final static PassThroughItemMeta metaData = new PassThroughItemMeta();
	
	@Override
	default RosettaMetaData<? extends PassThroughItem> metaData() {
		return metaData;
	} 
			
	static PassThroughItem.PassThroughItemBuilder builder() {
		return new PassThroughItem.PassThroughItemBuilderImpl();
	}
	
	default Class<? extends PassThroughItem> getType() {
		return PassThroughItem.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
		
		processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.class, getPayerReceiver());
	}
	
	
	interface PassThroughItemBuilder extends PassThroughItem, RosettaModelObjectBuilder {
		PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver();
		PayerReceiver.PayerReceiverBuilder getPayerReceiver();
		PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal passThroughPercentage);
		PassThroughItem.PassThroughItemBuilder setPayerReceiver(PayerReceiver payerReceiver);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
			
			processRosetta(path.newSubPath("payerReceiver"), processor, PayerReceiver.PayerReceiverBuilder.class, getPayerReceiver());
		}
		
	}
	
	//PassThroughItem.PassThroughItemImpl
	class PassThroughItemImpl implements PassThroughItem {
		private final BigDecimal passThroughPercentage;
		private final PayerReceiver payerReceiver;
		
		protected PassThroughItemImpl(PassThroughItem.PassThroughItemBuilder builder) {
			this.passThroughPercentage = builder.getPassThroughPercentage();
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@Override
		public PayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PassThroughItem build() {
			return this;
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			PassThroughItem.PassThroughItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PassThroughItem.PassThroughItemBuilder builder) {
			ofNullable(getPassThroughPercentage()).ifPresent(builder::setPassThroughPercentage);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItem {" +
				"passThroughPercentage=" + this.passThroughPercentage + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}';
		}
	}
	
	//PassThroughItem.PassThroughItemBuilderImpl
	class PassThroughItemBuilderImpl implements PassThroughItem.PassThroughItemBuilder {
	
		protected BigDecimal passThroughPercentage;
		protected PayerReceiver.PayerReceiverBuilder payerReceiver;
	
		public PassThroughItemBuilderImpl() {
		}
	
		@Override
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PayerReceiver.PayerReceiverBuilder getOrCreatePayerReceiver() {
			PayerReceiver.PayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PayerReceiver.builder();
			}
			
			return result;
		}
		
	
		@Override
		public PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal passThroughPercentage) {
			this.passThroughPercentage = passThroughPercentage==null?null:passThroughPercentage;
			return this;
		}
		@Override
		public PassThroughItem.PassThroughItemBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		
		@Override
		public PassThroughItem build() {
			return new PassThroughItem.PassThroughItemImpl(this);
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder prune() {
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPassThroughPercentage()!=null) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PassThroughItem.PassThroughItemBuilder o = (PassThroughItem.PassThroughItemBuilder) other;
			
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			
			merger.mergeBasic(getPassThroughPercentage(), o.getPassThroughPercentage(), this::setPassThroughPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItemBuilder {" +
				"passThroughPercentage=" + this.passThroughPercentage + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}';
		}
	}
}
