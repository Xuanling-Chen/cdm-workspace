package cdm.legalagreement.csa;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.NotificationTimeElectionMeta;
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
 * A class to specify the notification time election by the respective parties to the agreement. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(iii): Notification Time. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time.
 * @version ${project.version}
 */
@RosettaClass

public interface NotificationTimeElection extends RosettaModelObject {
	NotificationTimeElection build();
	NotificationTimeElection.NotificationTimeElectionBuilder toBuilder();
	
	/**
	 * The Notification Time as a custom election.
	 */
	String getCustomNotification();
	/**
	 * The Notification Time as a time that is qualified as a standard business center.
	 */
	BusinessCenterTime getNotificationTime();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static NotificationTimeElectionMeta metaData = new NotificationTimeElectionMeta();
	
	@Override
	default RosettaMetaData<? extends NotificationTimeElection> metaData() {
		return metaData;
	} 
			
	static NotificationTimeElection.NotificationTimeElectionBuilder builder() {
		return new NotificationTimeElection.NotificationTimeElectionBuilderImpl();
	}
	
	default Class<? extends NotificationTimeElection> getType() {
		return NotificationTimeElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customNotification"), String.class, getCustomNotification(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("notificationTime"), processor, BusinessCenterTime.class, getNotificationTime());
	}
	
	
	interface NotificationTimeElectionBuilder extends NotificationTimeElection, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateNotificationTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getNotificationTime();
		NotificationTimeElection.NotificationTimeElectionBuilder setCustomNotification(String customNotification);
		NotificationTimeElection.NotificationTimeElectionBuilder setNotificationTime(BusinessCenterTime notificationTime);
		NotificationTimeElection.NotificationTimeElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customNotification"), String.class, getCustomNotification(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("notificationTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getNotificationTime());
		}
		
	}
	
	//NotificationTimeElection.NotificationTimeElectionImpl
	class NotificationTimeElectionImpl implements NotificationTimeElection {
		private final String customNotification;
		private final BusinessCenterTime notificationTime;
		private final CounterpartyRoleEnum party;
		
		protected NotificationTimeElectionImpl(NotificationTimeElection.NotificationTimeElectionBuilder builder) {
			this.customNotification = builder.getCustomNotification();
			this.notificationTime = ofNullable(builder.getNotificationTime()).map(f->f.build()).orElse(null);
			this.party = builder.getParty();
		}
		
		@Override
		public String getCustomNotification() {
			return customNotification;
		}
		
		@Override
		public BusinessCenterTime getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public NotificationTimeElection build() {
			return this;
		}
		
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder toBuilder() {
			NotificationTimeElection.NotificationTimeElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotificationTimeElection.NotificationTimeElectionBuilder builder) {
			ofNullable(getCustomNotification()).ifPresent(builder::setCustomNotification);
			ofNullable(getNotificationTime()).ifPresent(builder::setNotificationTime);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTimeElection _that = getType().cast(o);
		
			if (!Objects.equals(customNotification, _that.getCustomNotification())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customNotification != null ? customNotification.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeElection {" +
				"customNotification=" + this.customNotification + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//NotificationTimeElection.NotificationTimeElectionBuilderImpl
	class NotificationTimeElectionBuilderImpl implements NotificationTimeElection.NotificationTimeElectionBuilder {
	
		protected String customNotification;
		protected BusinessCenterTime.BusinessCenterTimeBuilder notificationTime;
		protected CounterpartyRoleEnum party;
	
		public NotificationTimeElectionBuilderImpl() {
		}
	
		@Override
		public String getCustomNotification() {
			return customNotification;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getNotificationTime() {
			return notificationTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateNotificationTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (notificationTime!=null) {
				result = notificationTime;
			}
			else {
				result = notificationTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setCustomNotification(String customNotification) {
			this.customNotification = customNotification==null?null:customNotification;
			return this;
		}
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setNotificationTime(BusinessCenterTime notificationTime) {
			this.notificationTime = notificationTime==null?null:notificationTime.toBuilder();
			return this;
		}
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public NotificationTimeElection build() {
			return new NotificationTimeElection.NotificationTimeElectionImpl(this);
		}
		
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder prune() {
			if (notificationTime!=null && !notificationTime.prune().hasData()) notificationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomNotification()!=null) return true;
			if (getNotificationTime()!=null && getNotificationTime().hasData()) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTimeElection.NotificationTimeElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotificationTimeElection.NotificationTimeElectionBuilder o = (NotificationTimeElection.NotificationTimeElectionBuilder) other;
			
			merger.mergeRosetta(getNotificationTime(), o.getNotificationTime(), this::setNotificationTime);
			
			merger.mergeBasic(getCustomNotification(), o.getCustomNotification(), this::setCustomNotification);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTimeElection _that = getType().cast(o);
		
			if (!Objects.equals(customNotification, _that.getCustomNotification())) return false;
			if (!Objects.equals(notificationTime, _that.getNotificationTime())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customNotification != null ? customNotification.hashCode() : 0);
			_result = 31 * _result + (notificationTime != null ? notificationTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeElectionBuilder {" +
				"customNotification=" + this.customNotification + ", " +
				"notificationTime=" + this.notificationTime + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
