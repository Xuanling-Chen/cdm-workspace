package cdm.observable.event;

import cdm.observable.event.meta.EquityCorporateEventsMeta;
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
 * A class for defining the merger events and their treatment.
 * @version ${project.version}
 */
@RosettaClass

public interface EquityCorporateEvents extends RosettaModelObject {
	EquityCorporateEvents build();
	EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder();
	
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Merger Event (S-F-C) shall occur if a Merger Event occurs and the consideration for the relevant Security consists solely of Combined Consideration. | The consideration paid for the original shares following the Merger Event consists of both cash/securities and new shares.
	 */
	ShareExtraordinaryEventEnum getShareForCombined();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Merger Event (S-F-O) shall occur if a Merger Event occurs and the consideration for the relevant Security consists solely of Other Consideration. | The consideration paid for the original shares following the Merger Event consists wholly of cash/securities other than new shares.
	 */
	ShareExtraordinaryEventEnum getShareForOther();
	/**
	 * 2018 ISDA CDM Equity Confirmation for Security Equity Swap: Merger Event (S-F-S) shall occur if a Merger Event occurs and the consideration for the relevant Security consists solely of Combined Consideration. | The consideration paid for the original shares following the Merger Event consists wholly of new shares.
	 */
	ShareExtraordinaryEventEnum getShareForShare();
	final static EquityCorporateEventsMeta metaData = new EquityCorporateEventsMeta();
	
	@Override
	default RosettaMetaData<? extends EquityCorporateEvents> metaData() {
		return metaData;
	} 
			
	static EquityCorporateEvents.EquityCorporateEventsBuilder builder() {
		return new EquityCorporateEvents.EquityCorporateEventsBuilderImpl();
	}
	
	default Class<? extends EquityCorporateEvents> getType() {
		return EquityCorporateEvents.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
		processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
		processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
		
	}
	
	
	interface EquityCorporateEventsBuilder extends EquityCorporateEvents, RosettaModelObjectBuilder {
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum shareForCombined);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum shareForOther);
		EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum shareForShare);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("shareForCombined"), ShareExtraordinaryEventEnum.class, getShareForCombined(), this);
			processor.processBasic(path.newSubPath("shareForOther"), ShareExtraordinaryEventEnum.class, getShareForOther(), this);
			processor.processBasic(path.newSubPath("shareForShare"), ShareExtraordinaryEventEnum.class, getShareForShare(), this);
			
		}
		
	}
	
	//EquityCorporateEvents.EquityCorporateEventsImpl
	class EquityCorporateEventsImpl implements EquityCorporateEvents {
		private final ShareExtraordinaryEventEnum shareForCombined;
		private final ShareExtraordinaryEventEnum shareForOther;
		private final ShareExtraordinaryEventEnum shareForShare;
		
		protected EquityCorporateEventsImpl(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			this.shareForCombined = builder.getShareForCombined();
			this.shareForOther = builder.getShareForOther();
			this.shareForShare = builder.getShareForShare();
		}
		
		@Override
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@Override
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return this;
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			EquityCorporateEvents.EquityCorporateEventsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityCorporateEvents.EquityCorporateEventsBuilder builder) {
			ofNullable(getShareForCombined()).ifPresent(builder::setShareForCombined);
			ofNullable(getShareForOther()).ifPresent(builder::setShareForOther);
			ofNullable(getShareForShare()).ifPresent(builder::setShareForShare);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEvents {" +
				"shareForCombined=" + this.shareForCombined + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForShare=" + this.shareForShare +
			'}';
		}
	}
	
	//EquityCorporateEvents.EquityCorporateEventsBuilderImpl
	class EquityCorporateEventsBuilderImpl implements EquityCorporateEvents.EquityCorporateEventsBuilder {
	
		protected ShareExtraordinaryEventEnum shareForCombined;
		protected ShareExtraordinaryEventEnum shareForOther;
		protected ShareExtraordinaryEventEnum shareForShare;
	
		public EquityCorporateEventsBuilderImpl() {
		}
	
		@Override
		public ShareExtraordinaryEventEnum getShareForCombined() {
			return shareForCombined;
		}
		
		@Override
		public ShareExtraordinaryEventEnum getShareForOther() {
			return shareForOther;
		}
		
		@Override
		public ShareExtraordinaryEventEnum getShareForShare() {
			return shareForShare;
		}
		
	
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForCombined(ShareExtraordinaryEventEnum shareForCombined) {
			this.shareForCombined = shareForCombined==null?null:shareForCombined;
			return this;
		}
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForOther(ShareExtraordinaryEventEnum shareForOther) {
			this.shareForOther = shareForOther==null?null:shareForOther;
			return this;
		}
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder setShareForShare(ShareExtraordinaryEventEnum shareForShare) {
			this.shareForShare = shareForShare==null?null:shareForShare;
			return this;
		}
		
		@Override
		public EquityCorporateEvents build() {
			return new EquityCorporateEvents.EquityCorporateEventsImpl(this);
		}
		
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getShareForCombined()!=null) return true;
			if (getShareForOther()!=null) return true;
			if (getShareForShare()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityCorporateEvents.EquityCorporateEventsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityCorporateEvents.EquityCorporateEventsBuilder o = (EquityCorporateEvents.EquityCorporateEventsBuilder) other;
			
			
			merger.mergeBasic(getShareForCombined(), o.getShareForCombined(), this::setShareForCombined);
			merger.mergeBasic(getShareForOther(), o.getShareForOther(), this::setShareForOther);
			merger.mergeBasic(getShareForShare(), o.getShareForShare(), this::setShareForShare);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityCorporateEvents _that = getType().cast(o);
		
			if (!Objects.equals(shareForCombined, _that.getShareForCombined())) return false;
			if (!Objects.equals(shareForOther, _that.getShareForOther())) return false;
			if (!Objects.equals(shareForShare, _that.getShareForShare())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (shareForCombined != null ? shareForCombined.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForOther != null ? shareForOther.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shareForShare != null ? shareForShare.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityCorporateEventsBuilder {" +
				"shareForCombined=" + this.shareForCombined + ", " +
				"shareForOther=" + this.shareForOther + ", " +
				"shareForShare=" + this.shareForShare +
			'}';
		}
	}
}
