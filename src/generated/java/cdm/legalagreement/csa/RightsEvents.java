package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.RightsEventsMeta;
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
 * A class to specify the rights of Security Taker and/or Security Provider when an Early Termination or Access Condition event has occurred.
 * @version ${project.version}
 */
@RosettaClass

public interface RightsEvents extends RosettaModelObject {
	RightsEvents build();
	RightsEvents.RightsEventsBuilder toBuilder();
	
	/**
	 * The Additional Rights Event election.
	 */
	AdditionalRightsEvent getAdditionalRightsEvent();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Notice of Exclusive Control Event.
	 */
	ControlAgreementNecEvent getControlAgreementNecEvent();
	/**
	 * The specification of whether Delivery In Lieu language is applicable to the agreement (true) or not (false).
	 */
	Boolean getDeliveryInLieuRight();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Provider Rights Event.
	 */
	SecurityProviderRightsEvent getSecurityProviderRightsEvent();
	/**
	 * The bespoke provisions that might be specified by the parties to the agreement applicable to a Security Taker Rights Event.
	 */
	SecuredPartyRightsEvent getSecurityTakerRightsEvent();
	final static RightsEventsMeta metaData = new RightsEventsMeta();
	
	@Override
	default RosettaMetaData<? extends RightsEvents> metaData() {
		return metaData;
	} 
			
	static RightsEvents.RightsEventsBuilder builder() {
		return new RightsEvents.RightsEventsBuilderImpl();
	}
	
	default Class<? extends RightsEvents> getType() {
		return RightsEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
		
		processRosetta(path.newSubPath("additionalRightsEvent"), processor, AdditionalRightsEvent.class, getAdditionalRightsEvent());
		processRosetta(path.newSubPath("controlAgreementNecEvent"), processor, ControlAgreementNecEvent.class, getControlAgreementNecEvent());
		processRosetta(path.newSubPath("securityProviderRightsEvent"), processor, SecurityProviderRightsEvent.class, getSecurityProviderRightsEvent());
		processRosetta(path.newSubPath("securityTakerRightsEvent"), processor, SecuredPartyRightsEvent.class, getSecurityTakerRightsEvent());
	}
	
	
	interface RightsEventsBuilder extends RightsEvents, RosettaModelObjectBuilder {
		AdditionalRightsEvent.AdditionalRightsEventBuilder getOrCreateAdditionalRightsEvent();
		AdditionalRightsEvent.AdditionalRightsEventBuilder getAdditionalRightsEvent();
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder getOrCreateControlAgreementNecEvent();
		ControlAgreementNecEvent.ControlAgreementNecEventBuilder getControlAgreementNecEvent();
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getOrCreateSecurityProviderRightsEvent();
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getSecurityProviderRightsEvent();
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getOrCreateSecurityTakerRightsEvent();
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getSecurityTakerRightsEvent();
		RightsEvents.RightsEventsBuilder setAdditionalRightsEvent(AdditionalRightsEvent additionalRightsEvent);
		RightsEvents.RightsEventsBuilder setControlAgreementNecEvent(ControlAgreementNecEvent controlAgreementNecEvent);
		RightsEvents.RightsEventsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight);
		RightsEvents.RightsEventsBuilder setSecurityProviderRightsEvent(SecurityProviderRightsEvent securityProviderRightsEvent);
		RightsEvents.RightsEventsBuilder setSecurityTakerRightsEvent(SecuredPartyRightsEvent securityTakerRightsEvent);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("deliveryInLieuRight"), Boolean.class, getDeliveryInLieuRight(), this);
			
			processRosetta(path.newSubPath("additionalRightsEvent"), processor, AdditionalRightsEvent.AdditionalRightsEventBuilder.class, getAdditionalRightsEvent());
			processRosetta(path.newSubPath("controlAgreementNecEvent"), processor, ControlAgreementNecEvent.ControlAgreementNecEventBuilder.class, getControlAgreementNecEvent());
			processRosetta(path.newSubPath("securityProviderRightsEvent"), processor, SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder.class, getSecurityProviderRightsEvent());
			processRosetta(path.newSubPath("securityTakerRightsEvent"), processor, SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder.class, getSecurityTakerRightsEvent());
		}
		
	}
	
	//RightsEvents.RightsEventsImpl
	class RightsEventsImpl implements RightsEvents {
		private final AdditionalRightsEvent additionalRightsEvent;
		private final ControlAgreementNecEvent controlAgreementNecEvent;
		private final Boolean deliveryInLieuRight;
		private final SecurityProviderRightsEvent securityProviderRightsEvent;
		private final SecuredPartyRightsEvent securityTakerRightsEvent;
		
		protected RightsEventsImpl(RightsEvents.RightsEventsBuilder builder) {
			this.additionalRightsEvent = ofNullable(builder.getAdditionalRightsEvent()).map(f->f.build()).orElse(null);
			this.controlAgreementNecEvent = ofNullable(builder.getControlAgreementNecEvent()).map(f->f.build()).orElse(null);
			this.deliveryInLieuRight = builder.getDeliveryInLieuRight();
			this.securityProviderRightsEvent = ofNullable(builder.getSecurityProviderRightsEvent()).map(f->f.build()).orElse(null);
			this.securityTakerRightsEvent = ofNullable(builder.getSecurityTakerRightsEvent()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdditionalRightsEvent getAdditionalRightsEvent() {
			return additionalRightsEvent;
		}
		
		@Override
		public ControlAgreementNecEvent getControlAgreementNecEvent() {
			return controlAgreementNecEvent;
		}
		
		@Override
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		public SecurityProviderRightsEvent getSecurityProviderRightsEvent() {
			return securityProviderRightsEvent;
		}
		
		@Override
		public SecuredPartyRightsEvent getSecurityTakerRightsEvent() {
			return securityTakerRightsEvent;
		}
		
		@Override
		public RightsEvents build() {
			return this;
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder toBuilder() {
			RightsEvents.RightsEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RightsEvents.RightsEventsBuilder builder) {
			ofNullable(getAdditionalRightsEvent()).ifPresent(builder::setAdditionalRightsEvent);
			ofNullable(getControlAgreementNecEvent()).ifPresent(builder::setControlAgreementNecEvent);
			ofNullable(getDeliveryInLieuRight()).ifPresent(builder::setDeliveryInLieuRight);
			ofNullable(getSecurityProviderRightsEvent()).ifPresent(builder::setSecurityProviderRightsEvent);
			ofNullable(getSecurityTakerRightsEvent()).ifPresent(builder::setSecurityTakerRightsEvent);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RightsEvents _that = getType().cast(o);
		
			if (!Objects.equals(additionalRightsEvent, _that.getAdditionalRightsEvent())) return false;
			if (!Objects.equals(controlAgreementNecEvent, _that.getControlAgreementNecEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(securityProviderRightsEvent, _that.getSecurityProviderRightsEvent())) return false;
			if (!Objects.equals(securityTakerRightsEvent, _that.getSecurityTakerRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRightsEvent != null ? additionalRightsEvent.hashCode() : 0);
			_result = 31 * _result + (controlAgreementNecEvent != null ? controlAgreementNecEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (securityProviderRightsEvent != null ? securityProviderRightsEvent.hashCode() : 0);
			_result = 31 * _result + (securityTakerRightsEvent != null ? securityTakerRightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RightsEvents {" +
				"additionalRightsEvent=" + this.additionalRightsEvent + ", " +
				"controlAgreementNecEvent=" + this.controlAgreementNecEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"securityProviderRightsEvent=" + this.securityProviderRightsEvent + ", " +
				"securityTakerRightsEvent=" + this.securityTakerRightsEvent +
			'}';
		}
	}
	
	//RightsEvents.RightsEventsBuilderImpl
	class RightsEventsBuilderImpl implements RightsEvents.RightsEventsBuilder {
	
		protected AdditionalRightsEvent.AdditionalRightsEventBuilder additionalRightsEvent;
		protected ControlAgreementNecEvent.ControlAgreementNecEventBuilder controlAgreementNecEvent;
		protected Boolean deliveryInLieuRight;
		protected SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder securityProviderRightsEvent;
		protected SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder securityTakerRightsEvent;
	
		public RightsEventsBuilderImpl() {
		}
	
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder getAdditionalRightsEvent() {
			return additionalRightsEvent;
		}
		
		@Override
		public AdditionalRightsEvent.AdditionalRightsEventBuilder getOrCreateAdditionalRightsEvent() {
			AdditionalRightsEvent.AdditionalRightsEventBuilder result;
			if (additionalRightsEvent!=null) {
				result = additionalRightsEvent;
			}
			else {
				result = additionalRightsEvent = AdditionalRightsEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder getControlAgreementNecEvent() {
			return controlAgreementNecEvent;
		}
		
		@Override
		public ControlAgreementNecEvent.ControlAgreementNecEventBuilder getOrCreateControlAgreementNecEvent() {
			ControlAgreementNecEvent.ControlAgreementNecEventBuilder result;
			if (controlAgreementNecEvent!=null) {
				result = controlAgreementNecEvent;
			}
			else {
				result = controlAgreementNecEvent = ControlAgreementNecEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getDeliveryInLieuRight() {
			return deliveryInLieuRight;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getSecurityProviderRightsEvent() {
			return securityProviderRightsEvent;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder getOrCreateSecurityProviderRightsEvent() {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder result;
			if (securityProviderRightsEvent!=null) {
				result = securityProviderRightsEvent;
			}
			else {
				result = securityProviderRightsEvent = SecurityProviderRightsEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getSecurityTakerRightsEvent() {
			return securityTakerRightsEvent;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder getOrCreateSecurityTakerRightsEvent() {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder result;
			if (securityTakerRightsEvent!=null) {
				result = securityTakerRightsEvent;
			}
			else {
				result = securityTakerRightsEvent = SecuredPartyRightsEvent.builder();
			}
			
			return result;
		}
		
	
		@Override
		public RightsEvents.RightsEventsBuilder setAdditionalRightsEvent(AdditionalRightsEvent additionalRightsEvent) {
			this.additionalRightsEvent = additionalRightsEvent==null?null:additionalRightsEvent.toBuilder();
			return this;
		}
		@Override
		public RightsEvents.RightsEventsBuilder setControlAgreementNecEvent(ControlAgreementNecEvent controlAgreementNecEvent) {
			this.controlAgreementNecEvent = controlAgreementNecEvent==null?null:controlAgreementNecEvent.toBuilder();
			return this;
		}
		@Override
		public RightsEvents.RightsEventsBuilder setDeliveryInLieuRight(Boolean deliveryInLieuRight) {
			this.deliveryInLieuRight = deliveryInLieuRight==null?null:deliveryInLieuRight;
			return this;
		}
		@Override
		public RightsEvents.RightsEventsBuilder setSecurityProviderRightsEvent(SecurityProviderRightsEvent securityProviderRightsEvent) {
			this.securityProviderRightsEvent = securityProviderRightsEvent==null?null:securityProviderRightsEvent.toBuilder();
			return this;
		}
		@Override
		public RightsEvents.RightsEventsBuilder setSecurityTakerRightsEvent(SecuredPartyRightsEvent securityTakerRightsEvent) {
			this.securityTakerRightsEvent = securityTakerRightsEvent==null?null:securityTakerRightsEvent.toBuilder();
			return this;
		}
		
		@Override
		public RightsEvents build() {
			return new RightsEvents.RightsEventsImpl(this);
		}
		
		@Override
		public RightsEvents.RightsEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RightsEvents.RightsEventsBuilder prune() {
			if (additionalRightsEvent!=null && !additionalRightsEvent.prune().hasData()) additionalRightsEvent = null;
			if (controlAgreementNecEvent!=null && !controlAgreementNecEvent.prune().hasData()) controlAgreementNecEvent = null;
			if (securityProviderRightsEvent!=null && !securityProviderRightsEvent.prune().hasData()) securityProviderRightsEvent = null;
			if (securityTakerRightsEvent!=null && !securityTakerRightsEvent.prune().hasData()) securityTakerRightsEvent = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdditionalRightsEvent()!=null && getAdditionalRightsEvent().hasData()) return true;
			if (getControlAgreementNecEvent()!=null && getControlAgreementNecEvent().hasData()) return true;
			if (getDeliveryInLieuRight()!=null) return true;
			if (getSecurityProviderRightsEvent()!=null && getSecurityProviderRightsEvent().hasData()) return true;
			if (getSecurityTakerRightsEvent()!=null && getSecurityTakerRightsEvent().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RightsEvents.RightsEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RightsEvents.RightsEventsBuilder o = (RightsEvents.RightsEventsBuilder) other;
			
			merger.mergeRosetta(getAdditionalRightsEvent(), o.getAdditionalRightsEvent(), this::setAdditionalRightsEvent);
			merger.mergeRosetta(getControlAgreementNecEvent(), o.getControlAgreementNecEvent(), this::setControlAgreementNecEvent);
			merger.mergeRosetta(getSecurityProviderRightsEvent(), o.getSecurityProviderRightsEvent(), this::setSecurityProviderRightsEvent);
			merger.mergeRosetta(getSecurityTakerRightsEvent(), o.getSecurityTakerRightsEvent(), this::setSecurityTakerRightsEvent);
			
			merger.mergeBasic(getDeliveryInLieuRight(), o.getDeliveryInLieuRight(), this::setDeliveryInLieuRight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RightsEvents _that = getType().cast(o);
		
			if (!Objects.equals(additionalRightsEvent, _that.getAdditionalRightsEvent())) return false;
			if (!Objects.equals(controlAgreementNecEvent, _that.getControlAgreementNecEvent())) return false;
			if (!Objects.equals(deliveryInLieuRight, _that.getDeliveryInLieuRight())) return false;
			if (!Objects.equals(securityProviderRightsEvent, _that.getSecurityProviderRightsEvent())) return false;
			if (!Objects.equals(securityTakerRightsEvent, _that.getSecurityTakerRightsEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (additionalRightsEvent != null ? additionalRightsEvent.hashCode() : 0);
			_result = 31 * _result + (controlAgreementNecEvent != null ? controlAgreementNecEvent.hashCode() : 0);
			_result = 31 * _result + (deliveryInLieuRight != null ? deliveryInLieuRight.hashCode() : 0);
			_result = 31 * _result + (securityProviderRightsEvent != null ? securityProviderRightsEvent.hashCode() : 0);
			_result = 31 * _result + (securityTakerRightsEvent != null ? securityTakerRightsEvent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RightsEventsBuilder {" +
				"additionalRightsEvent=" + this.additionalRightsEvent + ", " +
				"controlAgreementNecEvent=" + this.controlAgreementNecEvent + ", " +
				"deliveryInLieuRight=" + this.deliveryInLieuRight + ", " +
				"securityProviderRightsEvent=" + this.securityProviderRightsEvent + ", " +
				"securityTakerRightsEvent=" + this.securityTakerRightsEvent +
			'}';
		}
	}
}
