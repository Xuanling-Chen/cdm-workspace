package cdm.event.workflow;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Lineage;
import cdm.event.workflow.meta.WorkflowStepMeta;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A workflow step represents the state of a business event. The workflow step contains a reference to a previous WorkflowStep in order to preserve lineage. A workflow step is accepted if it contains a business event, proposed if proposedInstruction is present and is rejected if the rejected flag is set.
 * @version ${project.version}
 */
@RosettaClass

public interface WorkflowStep extends RosettaModelObject, GlobalKey {
	WorkflowStep build();
	WorkflowStep.WorkflowStepBuilder toBuilder();
	
	/**
	 * Optional account information that could be associated to the event.
	 */
	List<? extends Account> getAccount();
	/**
	 * Specifies whether the event is a new, a correction or a cancellation.
	 */
	ActionEnum getAction();
	/**
	 * Life cycle event for the step. The businessEvent is optional when a proposedInstruction or rejection are present.
	 */
	BusinessEvent getBusinessEvent();
	/**
	 */
	CreditLimitInformation getCreditLimitInformation();
	/**
	 * The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.
	 */
	List<? extends Identifier> getEventIdentifier();
	/**
	 * The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).
	 */
	Lineage getLineage();
	/**
	 * Contains all information pertaining the FpML messaging header 
	 */
	MessageInformation getMessageInformation();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).
	 */
	List<? extends Party> getParty();
	/**
	 * Optional previous workflow step that provides lineage to workflow steps that precedes it.
	 */
	ReferenceWithMetaWorkflowStep getPreviousWorkflowStep();
	/**
	 * The proposed instruction for the next workflow step. The proposedInstruction is optional when the businessEvent or rejection are present
	 */
	Instruction getProposedInstruction();
	/**
	 * Flags this step as rejected.
	 */
	Boolean getRejected();
	/**
	 * The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].
	 */
	List<? extends EventTimestamp> getTimestamp();
	final static WorkflowStepMeta metaData = new WorkflowStepMeta();
	
	@Override
	default RosettaMetaData<? extends WorkflowStep> metaData() {
		return metaData;
	} 
			
	static WorkflowStep.WorkflowStepBuilder builder() {
		return new WorkflowStep.WorkflowStepBuilderImpl();
	}
	
	default Class<? extends WorkflowStep> getType() {
		return WorkflowStep.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("action"), ActionEnum.class, getAction(), this);
		processor.processBasic(path.newSubPath("rejected"), Boolean.class, getRejected(), this);
		
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("businessEvent"), processor, BusinessEvent.class, getBusinessEvent());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("lineage"), processor, Lineage.class, getLineage());
		processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.class, getMessageInformation());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("previousWorkflowStep"), processor, ReferenceWithMetaWorkflowStep.class, getPreviousWorkflowStep());
		processRosetta(path.newSubPath("proposedInstruction"), processor, Instruction.class, getProposedInstruction());
		processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.class, getTimestamp());
	}
	
	
	interface WorkflowStepBuilder extends WorkflowStep, RosettaModelObjectBuilder {
		Account.AccountBuilder getOrCreateAccount(int _index);
		List<? extends Account.AccountBuilder> getAccount();
		BusinessEvent.BusinessEventBuilder getOrCreateBusinessEvent();
		BusinessEvent.BusinessEventBuilder getBusinessEvent();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation();
		CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation();
		Identifier.IdentifierBuilder getOrCreateEventIdentifier(int _index);
		List<? extends Identifier.IdentifierBuilder> getEventIdentifier();
		Lineage.LineageBuilder getOrCreateLineage();
		Lineage.LineageBuilder getLineage();
		MessageInformation.MessageInformationBuilder getOrCreateMessageInformation();
		MessageInformation.MessageInformationBuilder getMessageInformation();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		ReferenceWithMetaWorkflowStepBuilder getOrCreatePreviousWorkflowStep();
		ReferenceWithMetaWorkflowStepBuilder getPreviousWorkflowStep();
		Instruction.InstructionBuilder getOrCreateProposedInstruction();
		Instruction.InstructionBuilder getProposedInstruction();
		EventTimestamp.EventTimestampBuilder getOrCreateTimestamp(int _index);
		List<? extends EventTimestamp.EventTimestampBuilder> getTimestamp();
		WorkflowStep.WorkflowStepBuilder addAccount(Account account);
		WorkflowStep.WorkflowStepBuilder addAccount(Account account, int _idx);
		WorkflowStep.WorkflowStepBuilder addAccount(List<? extends Account> account);
		WorkflowStep.WorkflowStepBuilder setAccount(List<? extends Account> account);
		WorkflowStep.WorkflowStepBuilder setAction(ActionEnum action);
		WorkflowStep.WorkflowStepBuilder setBusinessEvent(BusinessEvent businessEvent);
		WorkflowStep.WorkflowStepBuilder setCreditLimitInformation(CreditLimitInformation creditLimitInformation);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier, int _idx);
		WorkflowStep.WorkflowStepBuilder addEventIdentifier(List<? extends Identifier> eventIdentifier);
		WorkflowStep.WorkflowStepBuilder setEventIdentifier(List<? extends Identifier> eventIdentifier);
		WorkflowStep.WorkflowStepBuilder setLineage(Lineage lineage);
		WorkflowStep.WorkflowStepBuilder setMessageInformation(MessageInformation messageInformation);
		WorkflowStep.WorkflowStepBuilder setMeta(MetaFields meta);
		WorkflowStep.WorkflowStepBuilder addParty(Party party);
		WorkflowStep.WorkflowStepBuilder addParty(Party party, int _idx);
		WorkflowStep.WorkflowStepBuilder addParty(List<? extends Party> party);
		WorkflowStep.WorkflowStepBuilder setParty(List<? extends Party> party);
		WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep previousWorkflowStep);
		WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStepValue(WorkflowStep previousWorkflowStep);
		WorkflowStep.WorkflowStepBuilder setProposedInstruction(Instruction proposedInstruction);
		WorkflowStep.WorkflowStepBuilder setRejected(Boolean rejected);
		WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp);
		WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp, int _idx);
		WorkflowStep.WorkflowStepBuilder addTimestamp(List<? extends EventTimestamp> timestamp);
		WorkflowStep.WorkflowStepBuilder setTimestamp(List<? extends EventTimestamp> timestamp);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("action"), ActionEnum.class, getAction(), this);
			processor.processBasic(path.newSubPath("rejected"), Boolean.class, getRejected(), this);
			
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("businessEvent"), processor, BusinessEvent.BusinessEventBuilder.class, getBusinessEvent());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.IdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("lineage"), processor, Lineage.LineageBuilder.class, getLineage());
			processRosetta(path.newSubPath("messageInformation"), processor, MessageInformation.MessageInformationBuilder.class, getMessageInformation());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("previousWorkflowStep"), processor, ReferenceWithMetaWorkflowStepBuilder.class, getPreviousWorkflowStep());
			processRosetta(path.newSubPath("proposedInstruction"), processor, Instruction.InstructionBuilder.class, getProposedInstruction());
			processRosetta(path.newSubPath("timestamp"), processor, EventTimestamp.EventTimestampBuilder.class, getTimestamp());
		}
		
	}
	
	//WorkflowStep.WorkflowStepImpl
	class WorkflowStepImpl implements WorkflowStep {
		private final List<? extends Account> account;
		private final ActionEnum action;
		private final BusinessEvent businessEvent;
		private final CreditLimitInformation creditLimitInformation;
		private final List<? extends Identifier> eventIdentifier;
		private final Lineage lineage;
		private final MessageInformation messageInformation;
		private final MetaFields meta;
		private final List<? extends Party> party;
		private final ReferenceWithMetaWorkflowStep previousWorkflowStep;
		private final Instruction proposedInstruction;
		private final Boolean rejected;
		private final List<? extends EventTimestamp> timestamp;
		
		protected WorkflowStepImpl(WorkflowStep.WorkflowStepBuilder builder) {
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.action = builder.getAction();
			this.businessEvent = ofNullable(builder.getBusinessEvent()).map(f->f.build()).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.lineage = ofNullable(builder.getLineage()).map(f->f.build()).orElse(null);
			this.messageInformation = ofNullable(builder.getMessageInformation()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.previousWorkflowStep = ofNullable(builder.getPreviousWorkflowStep()).map(f->f.build()).orElse(null);
			this.proposedInstruction = ofNullable(builder.getProposedInstruction()).map(f->f.build()).orElse(null);
			this.rejected = builder.getRejected();
			this.timestamp = ofNullable(builder.getTimestamp()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public ActionEnum getAction() {
			return action;
		}
		
		@Override
		public BusinessEvent getBusinessEvent() {
			return businessEvent;
		}
		
		@Override
		public CreditLimitInformation getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public List<? extends Identifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public Lineage getLineage() {
			return lineage;
		}
		
		@Override
		public MessageInformation getMessageInformation() {
			return messageInformation;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep getPreviousWorkflowStep() {
			return previousWorkflowStep;
		}
		
		@Override
		public Instruction getProposedInstruction() {
			return proposedInstruction;
		}
		
		@Override
		public Boolean getRejected() {
			return rejected;
		}
		
		@Override
		public List<? extends EventTimestamp> getTimestamp() {
			return timestamp;
		}
		
		@Override
		public WorkflowStep build() {
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder toBuilder() {
			WorkflowStep.WorkflowStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WorkflowStep.WorkflowStepBuilder builder) {
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getAction()).ifPresent(builder::setAction);
			ofNullable(getBusinessEvent()).ifPresent(builder::setBusinessEvent);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getLineage()).ifPresent(builder::setLineage);
			ofNullable(getMessageInformation()).ifPresent(builder::setMessageInformation);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getPreviousWorkflowStep()).ifPresent(builder::setPreviousWorkflowStep);
			ofNullable(getProposedInstruction()).ifPresent(builder::setProposedInstruction);
			ofNullable(getRejected()).ifPresent(builder::setRejected);
			ofNullable(getTimestamp()).ifPresent(builder::setTimestamp);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStep _that = getType().cast(o);
		
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(businessEvent, _that.getBusinessEvent())) return false;
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(previousWorkflowStep, _that.getPreviousWorkflowStep())) return false;
			if (!Objects.equals(proposedInstruction, _that.getProposedInstruction())) return false;
			if (!Objects.equals(rejected, _that.getRejected())) return false;
			if (!ListEquals.listEquals(timestamp, _that.getTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessEvent != null ? businessEvent.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (previousWorkflowStep != null ? previousWorkflowStep.hashCode() : 0);
			_result = 31 * _result + (proposedInstruction != null ? proposedInstruction.hashCode() : 0);
			_result = 31 * _result + (rejected != null ? rejected.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStep {" +
				"account=" + this.account + ", " +
				"action=" + this.action + ", " +
				"businessEvent=" + this.businessEvent + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"lineage=" + this.lineage + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"meta=" + this.meta + ", " +
				"party=" + this.party + ", " +
				"previousWorkflowStep=" + this.previousWorkflowStep + ", " +
				"proposedInstruction=" + this.proposedInstruction + ", " +
				"rejected=" + this.rejected + ", " +
				"timestamp=" + this.timestamp +
			'}';
		}
	}
	
	//WorkflowStep.WorkflowStepBuilderImpl
	class WorkflowStepBuilderImpl implements WorkflowStep.WorkflowStepBuilder, GlobalKeyBuilder {
	
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected ActionEnum action;
		protected BusinessEvent.BusinessEventBuilder businessEvent;
		protected CreditLimitInformation.CreditLimitInformationBuilder creditLimitInformation;
		protected List<Identifier.IdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected Lineage.LineageBuilder lineage;
		protected MessageInformation.MessageInformationBuilder messageInformation;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected ReferenceWithMetaWorkflowStepBuilder previousWorkflowStep;
		protected Instruction.InstructionBuilder proposedInstruction;
		protected Boolean rejected;
		protected List<EventTimestamp.EventTimestampBuilder> timestamp = new ArrayList<>();
	
		public WorkflowStepBuilderImpl() {
		}
	
		@Override
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		public Account.AccountBuilder getOrCreateAccount(int _index) {
		
			if (account==null) {
				this.account = new ArrayList<>();
			}
			Account.AccountBuilder result;
			return getIndex(account, _index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@Override
		public ActionEnum getAction() {
			return action;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder getBusinessEvent() {
			return businessEvent;
		}
		
		@Override
		public BusinessEvent.BusinessEventBuilder getOrCreateBusinessEvent() {
			BusinessEvent.BusinessEventBuilder result;
			if (businessEvent!=null) {
				result = businessEvent;
			}
			else {
				result = businessEvent = BusinessEvent.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation() {
			CreditLimitInformation.CreditLimitInformationBuilder result;
			if (creditLimitInformation!=null) {
				result = creditLimitInformation;
			}
			else {
				result = creditLimitInformation = CreditLimitInformation.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends Identifier.IdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		public Identifier.IdentifierBuilder getOrCreateEventIdentifier(int _index) {
		
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(eventIdentifier, _index, () -> {
						Identifier.IdentifierBuilder newEventIdentifier = Identifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		public Lineage.LineageBuilder getLineage() {
			return lineage;
		}
		
		@Override
		public Lineage.LineageBuilder getOrCreateLineage() {
			Lineage.LineageBuilder result;
			if (lineage!=null) {
				result = lineage;
			}
			else {
				result = lineage = Lineage.builder();
			}
			
			return result;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder getMessageInformation() {
			return messageInformation;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder getOrCreateMessageInformation() {
			MessageInformation.MessageInformationBuilder result;
			if (messageInformation!=null) {
				result = messageInformation;
			}
			else {
				result = messageInformation = MessageInformation.builder();
			}
			
			return result;
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
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		public ReferenceWithMetaWorkflowStepBuilder getPreviousWorkflowStep() {
			return previousWorkflowStep;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStepBuilder getOrCreatePreviousWorkflowStep() {
			ReferenceWithMetaWorkflowStepBuilder result;
			if (previousWorkflowStep!=null) {
				result = previousWorkflowStep;
			}
			else {
				result = previousWorkflowStep = ReferenceWithMetaWorkflowStep.builder();
			}
			
			return result;
		}
		
		@Override
		public Instruction.InstructionBuilder getProposedInstruction() {
			return proposedInstruction;
		}
		
		@Override
		public Instruction.InstructionBuilder getOrCreateProposedInstruction() {
			Instruction.InstructionBuilder result;
			if (proposedInstruction!=null) {
				result = proposedInstruction;
			}
			else {
				result = proposedInstruction = Instruction.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getRejected() {
			return rejected;
		}
		
		@Override
		public List<? extends EventTimestamp.EventTimestampBuilder> getTimestamp() {
			return timestamp;
		}
		
		public EventTimestamp.EventTimestampBuilder getOrCreateTimestamp(int _index) {
		
			if (timestamp==null) {
				this.timestamp = new ArrayList<>();
			}
			EventTimestamp.EventTimestampBuilder result;
			return getIndex(timestamp, _index, () -> {
						EventTimestamp.EventTimestampBuilder newTimestamp = EventTimestamp.builder();
						return newTimestamp;
					});
		}
		
	
		@Override
		public WorkflowStep.WorkflowStepBuilder addAccount(Account account) {
			if (account!=null) this.account.add(account.toBuilder());
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addAccount(Account account, int _idx) {
			getIndex(this.account, _idx, () -> account.toBuilder());
			return this;
		}
		@Override 
		public WorkflowStep.WorkflowStepBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null)  {
				this.account = new ArrayList<>();
			}
			else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder setAction(ActionEnum action) {
			this.action = action==null?null:action;
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setBusinessEvent(BusinessEvent businessEvent) {
			this.businessEvent = businessEvent==null?null:businessEvent.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setCreditLimitInformation(CreditLimitInformation creditLimitInformation) {
			this.creditLimitInformation = creditLimitInformation==null?null:creditLimitInformation.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier) {
			if (eventIdentifier!=null) this.eventIdentifier.add(eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(Identifier eventIdentifier, int _idx) {
			getIndex(this.eventIdentifier, _idx, () -> eventIdentifier.toBuilder());
			return this;
		}
		@Override 
		public WorkflowStep.WorkflowStepBuilder addEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (Identifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder setEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers == null)  {
				this.eventIdentifier = new ArrayList<>();
			}
			else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder setLineage(Lineage lineage) {
			this.lineage = lineage==null?null:lineage.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setMessageInformation(MessageInformation messageInformation) {
			this.messageInformation = messageInformation==null?null:messageInformation.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public WorkflowStep.WorkflowStepBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep previousWorkflowStep) {
			this.previousWorkflowStep = previousWorkflowStep==null?null:previousWorkflowStep.toBuilder();
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder setPreviousWorkflowStepValue(WorkflowStep previousWorkflowStep) {
			this.getOrCreatePreviousWorkflowStep().setValue(previousWorkflowStep);
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setProposedInstruction(Instruction proposedInstruction) {
			this.proposedInstruction = proposedInstruction==null?null:proposedInstruction.toBuilder();
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder setRejected(Boolean rejected) {
			this.rejected = rejected==null?null:rejected;
			return this;
		}
		@Override
		public WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp) {
			if (timestamp!=null) this.timestamp.add(timestamp.toBuilder());
			return this;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder addTimestamp(EventTimestamp timestamp, int _idx) {
			getIndex(this.timestamp, _idx, () -> timestamp.toBuilder());
			return this;
		}
		@Override 
		public WorkflowStep.WorkflowStepBuilder addTimestamp(List<? extends EventTimestamp> timestamps) {
			if (timestamps != null) {
				for (EventTimestamp toAdd : timestamps) {
					this.timestamp.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public WorkflowStep.WorkflowStepBuilder setTimestamp(List<? extends EventTimestamp> timestamps) {
			if (timestamps == null)  {
				this.timestamp = new ArrayList<>();
			}
			else {
				this.timestamp = timestamps.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public WorkflowStep build() {
			return new WorkflowStep.WorkflowStepImpl(this);
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStep.WorkflowStepBuilder prune() {
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessEvent!=null && !businessEvent.prune().hasData()) businessEvent = null;
			if (creditLimitInformation!=null && !creditLimitInformation.prune().hasData()) creditLimitInformation = null;
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (lineage!=null && !lineage.prune().hasData()) lineage = null;
			if (messageInformation!=null && !messageInformation.prune().hasData()) messageInformation = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (previousWorkflowStep!=null && !previousWorkflowStep.prune().hasData()) previousWorkflowStep = null;
			if (proposedInstruction!=null && !proposedInstruction.prune().hasData()) proposedInstruction = null;
			timestamp = timestamp.stream().filter(b->b!=null).<EventTimestamp.EventTimestampBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAction()!=null) return true;
			if (getBusinessEvent()!=null && getBusinessEvent().hasData()) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLineage()!=null && getLineage().hasData()) return true;
			if (getMessageInformation()!=null && getMessageInformation().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPreviousWorkflowStep()!=null && getPreviousWorkflowStep().hasData()) return true;
			if (getProposedInstruction()!=null && getProposedInstruction().hasData()) return true;
			if (getRejected()!=null) return true;
			if (getTimestamp()!=null && getTimestamp().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WorkflowStep.WorkflowStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WorkflowStep.WorkflowStepBuilder o = (WorkflowStep.WorkflowStepBuilder) other;
			
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getBusinessEvent(), o.getBusinessEvent(), this::setBusinessEvent);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::setCreditLimitInformation);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			merger.mergeRosetta(getLineage(), o.getLineage(), this::setLineage);
			merger.mergeRosetta(getMessageInformation(), o.getMessageInformation(), this::setMessageInformation);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getPreviousWorkflowStep(), o.getPreviousWorkflowStep(), this::setPreviousWorkflowStep);
			merger.mergeRosetta(getProposedInstruction(), o.getProposedInstruction(), this::setProposedInstruction);
			merger.mergeRosetta(getTimestamp(), o.getTimestamp(), this::getOrCreateTimestamp);
			
			merger.mergeBasic(getAction(), o.getAction(), this::setAction);
			merger.mergeBasic(getRejected(), o.getRejected(), this::setRejected);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WorkflowStep _that = getType().cast(o);
		
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(action, _that.getAction())) return false;
			if (!Objects.equals(businessEvent, _that.getBusinessEvent())) return false;
			if (!Objects.equals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(lineage, _that.getLineage())) return false;
			if (!Objects.equals(messageInformation, _that.getMessageInformation())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!Objects.equals(previousWorkflowStep, _that.getPreviousWorkflowStep())) return false;
			if (!Objects.equals(proposedInstruction, _that.getProposedInstruction())) return false;
			if (!Objects.equals(rejected, _that.getRejected())) return false;
			if (!ListEquals.listEquals(timestamp, _that.getTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (action != null ? action.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (businessEvent != null ? businessEvent.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (lineage != null ? lineage.hashCode() : 0);
			_result = 31 * _result + (messageInformation != null ? messageInformation.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (previousWorkflowStep != null ? previousWorkflowStep.hashCode() : 0);
			_result = 31 * _result + (proposedInstruction != null ? proposedInstruction.hashCode() : 0);
			_result = 31 * _result + (rejected != null ? rejected.hashCode() : 0);
			_result = 31 * _result + (timestamp != null ? timestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WorkflowStepBuilder {" +
				"account=" + this.account + ", " +
				"action=" + this.action + ", " +
				"businessEvent=" + this.businessEvent + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"lineage=" + this.lineage + ", " +
				"messageInformation=" + this.messageInformation + ", " +
				"meta=" + this.meta + ", " +
				"party=" + this.party + ", " +
				"previousWorkflowStep=" + this.previousWorkflowStep + ", " +
				"proposedInstruction=" + this.proposedInstruction + ", " +
				"rejected=" + this.rejected + ", " +
				"timestamp=" + this.timestamp +
			'}';
		}
	}
}
